package com.wfx.order.controller;


import com.wfx.entity.View;
import com.wfx.order.service.IWxbOrderService;
import com.wfx.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-26
 */
@RestController
@CrossOrigin
@RequestMapping("/order/wxb-order")
public class WxbOrderController {
    @Autowired
    private IWxbOrderService iWxbOrderService;

    @RequestMapping("/searchByPage")
    public PageResult searchByPage(Integer page, Integer limit,@RequestBody View view){
        PageResult pageResult = iWxbOrderService.searchByPage(page,limit,view);
        return pageResult;
    }

}
