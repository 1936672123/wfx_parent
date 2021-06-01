package com.wfx.good.service;

import com.wfx.entity.WxbGoodCopy;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
public interface IWxbGoodCopyService extends IService<WxbGoodCopy> {
    PageResult<WxbGoodCopy> searchByPge(Integer page, Integer limit, WxbGoodCopy wxbGoodCopy);
    Result saveCopy(WxbGoodCopy wxbGoodCopy);
    Result deleteCopy(Integer copyId);
    Result updateCopy(WxbGoodCopy wxbGoodCopy);
}
