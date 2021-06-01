package com.wfx.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.gson.Gson;
import com.wfx.dto.UserDTO;
import com.wfx.goods.entity.WxbCustomer;
import com.wfx.goods.mapper.WxbCustomerMapper;
import com.wfx.goods.service.IWxbCustomerService;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Controller
@Service
public class WxbCustomerServiceImpl extends ServiceImpl<WxbCustomerMapper, WxbCustomer> implements IWxbCustomerService {

}
