package com.wfx.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wfx.entity.View;
import com.wfx.entity.WxbOrder;
import com.wfx.order.mapper.ViewMapper;
import com.wfx.order.mapper.WxbOrderMapper;
import com.wfx.order.service.IWxbOrderService;
import com.wfx.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-26
 */
@Service
@Transactional
public class WxbOrderServiceImpl extends ServiceImpl<WxbOrderMapper, WxbOrder> implements IWxbOrderService {
    @Autowired
    private ViewMapper viewMapper;

    @Override
    public PageResult searchByPage(Integer page, Integer limit,View view) {
        System.out.println("view------------"+view);
        QueryWrapper<View> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(view.getGoodName())){
            queryWrapper.like("good_name",view.getGoodName());
        }
        if(!StringUtils.isEmpty(view.getOrderId())){
            queryWrapper.eq("order_id",view.getOrderId());
        }
        if(!StringUtils.isEmpty(view.getAccount())){
            queryWrapper.eq("account",view.getAccount());
        }
        if(!StringUtils.isEmpty(view.getAddName())){
            queryWrapper.like("add_name",view.getAddName());
        }
        if(!StringUtils.isEmpty(view.getAddTel())){
            queryWrapper.eq("add_tel",view.getAddTel());
        }
        if(!StringUtils.isEmpty(view.getStartTime())){
            queryWrapper.ge("order_time",view.getStartTime()).le("order_time",view.getEndTime());
        }
        Page<View> viewPage = new Page<>(page, limit);
        //分页条件查询
        Page<View> pageInfo = viewMapper.selectPage(viewPage, queryWrapper);
        return new PageResult<View>(pageInfo.getRecords(),pageInfo.getTotal());
    }
}
