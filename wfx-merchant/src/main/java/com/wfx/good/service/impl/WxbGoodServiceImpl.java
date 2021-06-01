package com.wfx.good.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wfx.dto.GoodDTO;
import com.wfx.entity.*;
import com.wfx.good.mapper.WxbGoodCopyMapper;
import com.wfx.good.mapper.WxbGoodMapper;
import com.wfx.good.mapper.WxbGoodSkuMapper;
import com.wfx.good.service.IWxbGoodService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wfx.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
@Service
@Transactional
public class WxbGoodServiceImpl extends ServiceImpl<WxbGoodMapper, WxbGood> implements IWxbGoodService {

    @Autowired
    private WxbGoodMapper wxbGoodMapper;
    @Autowired
    private WxbGoodSkuMapper wxbGoodSkuMapper;
    @Autowired
    private WxbGoodCopyMapper wxbGoodCopyMapper;

    @Override
    public Result saveGood(GoodDTO goodDTO, WxbCustomer wxbCustomer) {
        WxbGood good = goodDTO.getGoods();
        List<WxbGoodSku> skuList = goodDTO.getGoodSkus();
        //存储商品信息
        String goodId = UUID.randomUUID().toString();
        good.setGoodId(goodId);
        good.setCreateTime(new Date());
        good.setCustomerId(wxbCustomer.getCustomerId());
        wxbGoodMapper.insert(good);
        //清空该商品可能存在的套餐
        wxbGoodSkuMapper.deleteByMap(new HashMap<String, Object>() {{
            put("good_id", goodId);
        }});
        //存储商品所有套餐
        for (WxbGoodSku wxbGoodSku : skuList) {
            wxbGoodSku.setSkuId(UUID.randomUUID().toString());
            wxbGoodSku.setGoodId(goodId);
            wxbGoodSkuMapper.insert(wxbGoodSku);
        }

        return new Result(true, "添加成功");
    }

    @Override
    public Result updateGood(GoodDTO goodDTO) {
        WxbGood goods = goodDTO.getGoods();
        List<WxbGoodSku> goodSkus = goodDTO.getGoodSkus();

        //修改商品套餐
        int delete = wxbGoodSkuMapper.deleteByMap(new HashMap<String, Object>() {{
            put("good_id", goods.getGoodId());
        }});
        int upsku=1;
        for (WxbGoodSku skus : goodSkus) {
            skus.setSkuId(UUID.randomUUID().toString());
            skus.setGoodId(goods.getGoodId());
            int insert = wxbGoodSkuMapper.insert(skus);
            upsku=upsku*insert;
        }

        //修改商品
        int update = wxbGoodMapper.updateById(goods);
        if (0!=update*upsku){
            return new Result(true, "修改商品成功");
        }else{
            return new Result(false,"修改商品失败");
        }

    }

    @Override
    public Result deleteGood(String goodId) {

        int i1 = wxbGoodSkuMapper.deleteByMap(new HashMap<String, Object>() {{
            put("good_id", goodId);
        }});
        int i2 = wxbGoodMapper.deleteById(goodId);

        if (i1*i2!=0) {
            wxbGoodMapper.deleteById(goodId);
            return new Result(true, "删除成功");
        }
        return new Result(false, "删除失败");
    }

    @Override
    public GoodDTO showUpdate(String goodId) {
        WxbGood wxbGood = wxbGoodMapper.selectById(goodId);
        List<WxbGoodSku> wxbGoodSkus = wxbGoodSkuMapper.selectByMap(new HashMap<String, Object>() {{
            put("good_id", goodId);
        }});
        GoodDTO goodDTO = new GoodDTO(wxbGood, wxbGoodSkus);
        return goodDTO;
    }
}
