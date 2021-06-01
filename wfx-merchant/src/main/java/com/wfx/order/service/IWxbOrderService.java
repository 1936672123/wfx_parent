package com.wfx.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wfx.entity.View;
import com.wfx.entity.WxbOrder;
import com.wfx.vo.PageResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-26
 */
public interface IWxbOrderService extends IService<WxbOrder> {

    PageResult searchByPage(Integer page, Integer limit,View view);


}
