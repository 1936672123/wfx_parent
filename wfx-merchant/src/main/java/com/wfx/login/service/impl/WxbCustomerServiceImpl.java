package com.wfx.login.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.wfx.dto.UserDTO;
import com.wfx.entity.WxbCustomer;
import com.wfx.login.mapper.WxbCustomerMapper;
import com.wfx.login.service.IWxbCustomerService;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-21
 */
@Service
public class WxbCustomerServiceImpl extends ServiceImpl<WxbCustomerMapper, WxbCustomer> implements IWxbCustomerService {

    @Autowired
    private WxbCustomerMapper wxbCustomerMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Result login(UserDTO userDTO) {
        QueryWrapper<WxbCustomer> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name",userDTO.getUsername()).eq("login_pwd",userDTO.getPassword());
        WxbCustomer wxbCustomer = wxbCustomerMapper.selectOne(queryWrapper);
        if (null == wxbCustomer) {//登录失败
            return new Result(false,"登录失败");
        }else{//登录成功
            String token= UUID.randomUUID().toString();
            String key="merchant:token:"+token;
            String value = new Gson().toJson(wxbCustomer);
            //存到redis中
            stringRedisTemplate.boundValueOps(key).set(value);
            return new Result<String>(true, "登录成功", token);
        }
    }

    @Override
    public Result logOut(String token) {
        String key="merchant:token:"+token;
        Boolean delete = stringRedisTemplate.delete(key);
        if(delete){
            return new Result<>(true,"注销成功");
        }else{
            return new Result<>(false,"注销失败");
        }
    }


}
