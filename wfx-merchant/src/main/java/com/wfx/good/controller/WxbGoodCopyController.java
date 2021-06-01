package com.wfx.good.controller;


import com.wfx.entity.WxbGoodCopy;
import com.wfx.good.service.IWxbGoodCopyService;
import com.wfx.vo.PageResult;
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
@RequestMapping("/good/wxb-good-copy")
public class WxbGoodCopyController {

    @Autowired
    private IWxbGoodCopyService iWxbGoodCopyService;

   @ResponseBody
   @PostMapping("/searchByPage")
   public PageResult<WxbGoodCopy> searchByPge(Integer page, Integer limit, @RequestBody WxbGoodCopy wxbGoodCopy){
       PageResult<WxbGoodCopy> pageResult = iWxbGoodCopyService.searchByPge(page, limit, wxbGoodCopy);
//       System.out.println("list="+pageResult.getList());
       return pageResult;
   }
   
   @ResponseBody
   @PostMapping("/save")
   public Result save(@RequestBody WxbGoodCopy wxbGoodCopy){
       Result result = iWxbGoodCopyService.saveCopy(wxbGoodCopy);
       return result;
   }

   @GetMapping("/deleteCopy")
   @ResponseBody
   public Result deleteCopy(Integer copyId){
       Result result = iWxbGoodCopyService.deleteCopy(copyId);
       return result;
   }

   @ResponseBody
   @PostMapping("/updateCopy")
   public Result updateCopy(@RequestBody WxbGoodCopy wxbGoodCopy){
       Result result = iWxbGoodCopyService.updateCopy(wxbGoodCopy);
       return result;
   }

   @RequestMapping("/findAll")
   @ResponseBody
   public List<WxbGoodCopy> findAll(){
       List<WxbGoodCopy> list = iWxbGoodCopyService.list();
       return list;
   }


}
