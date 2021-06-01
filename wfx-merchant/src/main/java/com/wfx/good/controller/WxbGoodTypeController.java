package com.wfx.good.controller;


import com.wfx.entity.WxbGoodType;
import com.wfx.good.service.IWxbGoodTypeService;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
@Controller
@CrossOrigin
@RequestMapping("/good/wxb-good-type")
public class WxbGoodTypeController {

    @Autowired
    private IWxbGoodTypeService iWxbGoodTypeService;

    @RequestMapping("/findAll")
    @ResponseBody
    public List<WxbGoodType> findAll(){
        List<WxbGoodType> list = iWxbGoodTypeService.list();
        return list;
    }


}
