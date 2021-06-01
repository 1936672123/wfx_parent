package com.wfx.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wfx.dto.MemberRegister;
import com.wfx.dto.UserDTO;
import com.wfx.goods.entity.WxbMemeber;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-25
 */
public interface IWxbMemeberService extends IService<WxbMemeber> {

    Result login(UserDTO userDTO);

    Result register(MemberRegister memberRegister);

    Result checkAccount(String account);
    Result checkPhone(String phone);

    PageResult searchGoodsByPage(Integer page,Integer limit);

    Result getCode(MemberRegister memberRegister);

}
