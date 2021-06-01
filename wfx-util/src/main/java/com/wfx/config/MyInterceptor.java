package com.wfx.config;

import com.google.gson.Gson;
import com.wfx.entity.WxbCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Component
public class MyInterceptor implements HandlerInterceptor {
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        //放行OPTIONS
        if ("OPTIONS".equals(request.getMethod())){
            return true;
        }
        //判断是否有token
        String token = request.getHeader("token");
        if (null == token) {
            return false;
        }
        System.out.println("token="+token);
        String loginMsg = stringRedisTemplate.boundValueOps("merchant:token:" + token).get();
        if (null == loginMsg) {
            return false;
        }
        WxbCustomer wxbCustomer = new Gson().fromJson(loginMsg, WxbCustomer.class);
        System.out.println("loginUser="+wxbCustomer);
        request.setAttribute("wxbCustomer",wxbCustomer);
        return true;
    }


}
