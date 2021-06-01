package com.wfx.login.controller;

import com.wfx.dto.UserDTO;
import com.wfx.login.service.IWxbCustomerService;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IWxbCustomerService iWxbCustomerService;

    @PostMapping("/login")
    @ResponseBody
    public Result index(@RequestBody UserDTO userDTO){
        Result result = iWxbCustomerService.login(userDTO);
        return result;
    }

    @GetMapping("/logout")
    @ResponseBody
    public Result logOut(String token){
        Result result = iWxbCustomerService.logOut(token);
        return result;
    }

}
