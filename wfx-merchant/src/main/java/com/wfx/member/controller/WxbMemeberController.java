package com.wfx.member.controller;


import com.wfx.entity.WxbMemeber;
import com.wfx.member.service.IWxbMemeberService;
import com.wfx.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
@Controller
@RequestMapping("/member")
@CrossOrigin
public class WxbMemeberController {
    @Autowired
    private IWxbMemeberService iWxbMemeberService;

    @RequestMapping("search")
    @ResponseBody
    public PageResult<WxbMemeber> search(Integer page, Integer limit, @RequestBody WxbMemeber member){
//        System.out.println("page="+page);
//        System.out.println("limit="+limit);
//        System.out.println("member="+member);
        return iWxbMemeberService.search(page,limit,member);
    }

}
