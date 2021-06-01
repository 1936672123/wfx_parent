package com.wfx.login.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wfx.dto.UserDTO;
import com.wfx.entity.WxbCustomer;
import com.wfx.vo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2020-10-21
 */
public interface IWxbCustomerService extends IService<WxbCustomer> {

    Result  login(UserDTO userDTO);

    Result logOut(String token);

}
