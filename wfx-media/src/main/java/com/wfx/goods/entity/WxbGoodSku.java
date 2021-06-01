package com.wfx.goods.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxbGoodSku implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 套餐主键
     */
    @TableId
    private String skuId;

    /**
     * 套餐名称
     */
    private String skuName;

    /**
     * 成本
     */
    private String skuCost;

    /**
     * 价格
     */
    private String skuPrice;

    /**
     * 分成
     */
    private String skuPmoney;

    /**
     * 商品ID
     */
    private String goodId;

    /**
     * 排序
     */
    private Integer orderNo;

    /**
     * 客服提成
     */
    private String serviceMoney;


}
