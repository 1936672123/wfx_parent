package com.wfx.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wfx.entity.WxbMemeber;
import com.wfx.member.mapper.WxbMemeberMapper;
import com.wfx.member.service.IWxbMemeberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wfx.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
@Service
public class WxbMemeberServiceImpl extends ServiceImpl<WxbMemeberMapper, WxbMemeber> implements IWxbMemeberService {

    @Autowired
    private WxbMemeberMapper wxbMemeberMapper;

    @Override
    public PageResult<WxbMemeber> search(Integer page, Integer limit, WxbMemeber wxbMemeber) {
        //分页信息
        IPage<WxbMemeber> iPage = new Page<>(page,limit);
        //条件构造器
        QueryWrapper<WxbMemeber> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(wxbMemeber.getAccount())){
            queryWrapper.eq("account",wxbMemeber.getAccount());
        }
        if(!StringUtils.isEmpty(wxbMemeber.getStartTime())){
            queryWrapper.ge("register_time",wxbMemeber.getStartTime());
        }
        if(!StringUtils.isEmpty(wxbMemeber.getEndTime())){
            queryWrapper.le("register_time",wxbMemeber.getEndTime());
        }

        IPage<WxbMemeber> pageinfo = wxbMemeberMapper.selectPage(iPage, queryWrapper);

        PageResult<WxbMemeber> pageResult = new PageResult<>();
        pageResult.setTotal(pageinfo.getTotal());
        pageResult.setList(pageinfo.getRecords());

        return pageResult;
    }
}
