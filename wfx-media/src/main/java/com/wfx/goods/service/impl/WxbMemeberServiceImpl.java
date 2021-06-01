package com.wfx.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.wfx.dto.MemberRegister;
import com.wfx.dto.UserDTO;
import com.wfx.goods.entity.WxbCustomer;
import com.wfx.goods.entity.WxbMemeber;
import com.wfx.goods.entity.ZiGoodsV;
import com.wfx.goods.mapper.WxbCustomerMapper;
import com.wfx.goods.mapper.WxbMemeberMapper;
import com.wfx.goods.mapper.ZiGoodsVMapper;
import com.wfx.goods.service.IWxbMemeberService;
import com.wfx.util.SendMessageUtil;
import com.wfx.util.VerifyCodeUtil;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-25
 */
@Service
public class WxbMemeberServiceImpl extends ServiceImpl<WxbMemeberMapper, WxbMemeber> implements IWxbMemeberService {

    @Autowired
    private WxbMemeberMapper wxbMemeberMapper ;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private ZiGoodsVMapper ziGoodsVMapper;

    @Override
    public Result login(UserDTO userDTO) {

        QueryWrapper<WxbMemeber> queryWrapper = new QueryWrapper<>();
        queryWrapper.and(qw->qw
                .eq("account",userDTO.getUsername())
                .or().eq("email",userDTO.getUsername())
                .or().eq("phone",userDTO.getUsername()))
                .eq("password",userDTO.getPassword());
        WxbMemeber wxbMemeber = wxbMemeberMapper.selectOne(queryWrapper);
        //登录成功
        if(null!=wxbMemeber){
            String token= UUID.randomUUID().toString();
            String key="media:token:"+token;
            String value=new Gson().toJson(wxbMemeber);
            stringRedisTemplate.boundValueOps(key).set(value);
            return new Result<>(true, "登录成功", token);
        }
        //登录失败
        return new Result(false,"登陆失败");
    }

    @Override
    public Result register(MemberRegister memberRegister) {

        String registerCode = stringRedisTemplate.boundValueOps("media:registerCode:" + memberRegister.getPhone()).get();
//        System.out.println("registerCode="+registerCode);
//        System.out.println("code="+memberRegister.getCode());
        if(null==registerCode){
            return new Result(false,"短信验证码已过期");
        }
        if(!registerCode.equals(memberRegister.getCode())){
            return new Result(false,"验证码错误");
        }
        //验证码匹配成功
        WxbMemeber wxbMemeber = new WxbMemeber();
        wxbMemeber.setMemeberId(UUID.randomUUID().toString());
        wxbMemeber.setUseRecom(0);
        wxbMemeber.setPayAccount(memberRegister.getPhone());
        wxbMemeber.setAccount(memberRegister.getAccount());
        wxbMemeber.setPassword(memberRegister.getPassword());
        wxbMemeber.setPhone(memberRegister.getPhone());
        int insert = wxbMemeberMapper.insert(wxbMemeber);
        if(insert==0){
            return new Result(false,"注册失败");
        }
        return new Result(true,"恭喜你！注册成功");
    }

    @Override
    public Result checkAccount(String account) {
        List<WxbMemeber> wxbMemebers = wxbMemeberMapper.selectByMap(new HashMap<String, Object>() {{
            put("account", account);
        }});
        if (wxbMemebers.size() == 0) {
            return new Result(true,"可以使用");
        }
        return new Result(false,"已被占用");
    }

    @Override
    public Result checkPhone(String phone) {
        List<WxbMemeber> wxbMemebers = wxbMemeberMapper.selectByMap(new HashMap<String, Object>() {{
            put("phone", phone);
        }});
        if (wxbMemebers.size() == 0) {
            return new Result(true,"可以使用");
        }
        return new Result(false,"已被使用");
    }

    @Override
    public PageResult searchGoodsByPage(Integer page, Integer limit) {

        Page<ZiGoodsV> ziGoodsVPage = new Page<>(page, limit);
        //构造分页+条件查询构造器
        QueryWrapper<ZiGoodsV> queryWrapper = new QueryWrapper<>();


        Page<ZiGoodsV> pageInfo = ziGoodsVMapper.selectPage(ziGoodsVPage, queryWrapper);
        PageResult<ZiGoodsV> pageResult = new PageResult<>(pageInfo.getRecords(), pageInfo.getTotal());
        return pageResult;
    }

    @Override
    public Result getCode(MemberRegister memberRegister) {

        String phone = memberRegister.getPhone();
        if(null==phone||""==phone){
            return new Result(false,"手机号不能为空");
        }
        QueryWrapper<WxbMemeber> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone",phone);
        WxbMemeber wxbMemeber = wxbMemeberMapper.selectOne(queryWrapper);
        if (null == wxbMemeber) {//该手机号没被注册
            String verifyCode = VerifyCodeUtil.generateVerifyCode(4);
            String key="media:registerCode:"+phone;
            //将注册验证码缓存到redis中
            stringRedisTemplate.boundValueOps(key).set(verifyCode);
            stringRedisTemplate.expire(key,70, TimeUnit.SECONDS);
            System.out.println("================");
            //发送验证码短信给用户
            SendMessageUtil.sendMsg(phone,verifyCode);
            return new Result(true,"发送成功");
        }
        return new Result(false,"该手机号已存在");
    }
}
