package com.wfx.member.service;

import com.wfx.entity.WxbMemeber;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wfx.vo.PageResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
public interface IWxbMemeberService extends IService<WxbMemeber> {

    PageResult<WxbMemeber> search(Integer page, Integer limit, WxbMemeber wxbMemeber);

}
