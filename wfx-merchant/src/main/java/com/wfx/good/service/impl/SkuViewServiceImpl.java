package com.wfx.good.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wfx.entity.SkuView;
import com.wfx.entity.WxbGood;
import com.wfx.good.mapper.SkuViewMapper;
import com.wfx.good.service.ISkuViewService;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * VIEW 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-22
 */
@Service

public class SkuViewServiceImpl extends ServiceImpl<SkuViewMapper, SkuView> implements ISkuViewService {

    @Autowired
    private SkuViewMapper skuViewMapper;

    @Override
    public PageResult<SkuView> searchGood(Integer page, Integer limit, WxbGood wxbGood) {
        Page<SkuView> page1 = new Page<>(page, limit);
        QueryWrapper<SkuView> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(wxbGood.getGoodName())) {
            queryWrapper.like("good_name", wxbGood.getGoodName());
        }
        Page<SkuView> pageinfo = skuViewMapper.selectPage(page1, queryWrapper);
        //封装返回给前端的数据
        PageResult<SkuView> pageResult = new PageResult<>(pageinfo.getRecords(),pageinfo.getTotal());
        return pageResult;
    }
}
