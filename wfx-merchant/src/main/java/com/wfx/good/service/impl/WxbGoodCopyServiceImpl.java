package com.wfx.good.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wfx.entity.WxbGoodCopy;
import com.wfx.good.mapper.WxbGoodCopyMapper;
import com.wfx.good.service.IWxbGoodCopyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wfx.vo.PageResult;
import com.wfx.vo.Result;
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
 * @since 2020-10-19
 */
@Service
@Transactional
public class WxbGoodCopyServiceImpl extends ServiceImpl<WxbGoodCopyMapper, WxbGoodCopy> implements IWxbGoodCopyService {
    @Autowired
    private WxbGoodCopyMapper wxbGoodCopyMapper;

    @Override
    public PageResult<WxbGoodCopy> searchByPge(Integer page, Integer limit, WxbGoodCopy wxbGoodCopy) {
        Page<WxbGoodCopy> copyPage = new Page<>(page, limit);
        QueryWrapper<WxbGoodCopy> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(wxbGoodCopy.getCopyId())){
            queryWrapper.eq("copy_id",wxbGoodCopy.getCopyId());
        }
        if(!StringUtils.isEmpty(wxbGoodCopy.getCopyTitle())){
            queryWrapper.like("copy_title",wxbGoodCopy.getCopyTitle());
        }
        Page<WxbGoodCopy> pageInfo = wxbGoodCopyMapper.selectPage(copyPage, queryWrapper);
        PageResult<WxbGoodCopy> pageResult = new PageResult<>();
        pageResult.setTotal(pageInfo.getTotal());
        pageResult.setList(pageInfo.getRecords());
        return pageResult;
    }

    @Override
    public Result saveCopy(WxbGoodCopy wxbGoodCopy) {
        if(!StringUtils.isEmpty(wxbGoodCopy.getCopyTitle())){
            int insert = wxbGoodCopyMapper.insert(wxbGoodCopy);
            return new Result(true,"添加成功");
        }else{
            return new Result(false,"添加失败");
        }
    }

    @Override
    public Result deleteCopy(Integer copyId) {
        int i = wxbGoodCopyMapper.deleteById(copyId);
        Result<Object> result = new Result<>();
        if(i!=0){
            result.setSuccess(true);
            result.setMsg("success");
        }else{
            result.setSuccess(false);
            result.setMsg("false");
        }
        return  result;
    }

    @Override
    public Result updateCopy(WxbGoodCopy wxbGoodCopy) {
        UpdateWrapper<WxbGoodCopy> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("copy_id",wxbGoodCopy.getCopyId()).set("copy_title",wxbGoodCopy.getCopyTitle()).set("copy_content",wxbGoodCopy.getCopyContent()).set("type_id",wxbGoodCopy.getTypeId());
        int update = wxbGoodCopyMapper.update(null, updateWrapper);
        Result result = new Result();
        if(0!=update){
            result.setSuccess(true);
            result.setMsg("success");
        }else{
            result.setSuccess(false);
            result.setMsg("false");
        }
        return result;
    }


}
