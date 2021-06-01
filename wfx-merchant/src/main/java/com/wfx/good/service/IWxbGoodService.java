package com.wfx.good.service;

import com.wfx.dto.GoodDTO;
import com.wfx.entity.SkuView;
import com.wfx.entity.WxbCustomer;
import com.wfx.entity.WxbGood;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wfx.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
public interface IWxbGoodService extends IService<WxbGood> {

    Result saveGood(GoodDTO goodDTO, WxbCustomer wxbCustomer);
    Result updateGood(GoodDTO goodDTO);
    Result deleteGood(String goodId);
    GoodDTO showUpdate(String goodId);

}
