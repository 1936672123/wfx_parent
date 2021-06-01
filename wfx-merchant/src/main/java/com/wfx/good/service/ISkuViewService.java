package com.wfx.good.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wfx.entity.SkuView;
import com.wfx.entity.WxbGood;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;

/**
 * <p>
 * VIEW 服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-22
 */
public interface ISkuViewService extends IService<SkuView> {

    PageResult<SkuView> searchGood(Integer page, Integer limit, WxbGood wxbGood);

}
