package com.wfx.good.mapper;

import com.wfx.entity.WxbGood;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
public interface WxbGoodMapper extends BaseMapper<WxbGood> {
    WxbGood findAllGood();
}
