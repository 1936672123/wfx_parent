package com.wfx.good.controller;


import com.wfx.dto.GoodDTO;
import com.wfx.entity.SkuView;
import com.wfx.entity.WxbCustomer;
import com.wfx.entity.WxbGood;
import com.wfx.good.service.ISkuViewService;
import com.wfx.good.service.IWxbGoodService;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Scanner;

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
@RequestMapping("/good/wxb-good")
public class WxbGoodController {

    @Autowired
    private IWxbGoodService iWxbGoodService;
    @Autowired
    private ISkuViewService iSkuViewService;

    @ResponseBody
    @PostMapping("/save")
    public Result saveGood(@RequestBody GoodDTO goodDTO, HttpServletRequest request){
        WxbCustomer wxbCustomer = (WxbCustomer) request.getAttribute("wxbCustomer");
        return iWxbGoodService.saveGood(goodDTO,wxbCustomer);
    }

    @PostMapping("/search")
    @ResponseBody
    public PageResult search(Integer page, Integer limit, @RequestBody WxbGood wxbGood){
        PageResult<SkuView> pageResult = iSkuViewService.searchGood(page, limit, wxbGood);
        return pageResult;
    }

    @RequestMapping("/deleteGood")
    @ResponseBody
    public Result deleteGood(String goodId){
        Result result = iWxbGoodService.deleteGood(goodId);
        return result;
    }

    @PostMapping("/updateGood")
    @ResponseBody
    public Result updateGood(@RequestBody GoodDTO goodDTO){
        Result result = iWxbGoodService.updateGood(goodDTO);
        return result;
    }

    @GetMapping("/showUpdate")
    @ResponseBody
    public GoodDTO showUpdate(String goodId){
        GoodDTO goodDTO = iWxbGoodService.showUpdate(goodId);
        return goodDTO;
    }



}
