package com.wfx.goods.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wfx.dto.MemberRegister;
import com.wfx.dto.UserDTO;
import com.wfx.goods.entity.WxbMemeber;
import com.wfx.goods.entity.ZiGoodsV;
import com.wfx.goods.service.IWxbMemeberService;
import com.wfx.util.SendMessageUtil;
import com.wfx.util.VerifyCodeUtil;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-25
 */
@Controller
@RequestMapping("/memeber")
@CrossOrigin(origins = "http://127.0.0.1:5500",allowCredentials = "true")
public class WxbMemeberController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private IWxbMemeberService iWxbMemeberService;

    @PostMapping("/login")
    @ResponseBody
    public Result login(@RequestBody UserDTO userDTO){
        Result result = iWxbMemeberService.login(userDTO);
        return result;
    }

    @PostMapping("/register")
    @ResponseBody
    public Result register(@RequestBody MemberRegister memberRegister){
        //注册用户
        Result result = iWxbMemeberService.register(memberRegister);
        return result;
    }

    @PostMapping("/getCode")
    @ResponseBody
    public Result getCode(@RequestBody MemberRegister memberRegister){
        Result result = iWxbMemeberService.getCode(memberRegister);
        return result;
    }

    @RequestMapping("/check/{value}/{id}")
    @ResponseBody
    public Result checkAccount(@PathVariable("value") String value,@PathVariable("id") Integer id){
       if(id==1){
           Result result = iWxbMemeberService.checkAccount(value);
           return result;
       }else if(id==2){
           Result result = iWxbMemeberService.checkPhone(value);
           return result;
       }
       return new Result(false, "你可真厉害！！！");
    }

    @PostMapping("/searchGoodsByPage")
    @ResponseBody
    public PageResult searchGoodsByPage(@RequestBody ZiGoodsV ziGoodsV,Integer page,Integer limit){
        PageResult pageResult = iWxbMemeberService.searchGoodsByPage(page, limit);
        return pageResult;
    }



}
