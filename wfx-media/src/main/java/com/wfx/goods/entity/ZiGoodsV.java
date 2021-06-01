package com.wfx.goods.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jobob
 * @since 2020-10-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ZiGoodsV implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String goodId;

    /**
     * 商品图片
     */
    private String goodPic;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 推广说明
     */
    private String promoteDesc;

    /**
     * 商品分类
     */
    private String typeId;

    /**
     * 排序编号
     */
    private Integer orderNo;

    /**
     * 是否置顶 0 取消置顶 1 置顶
     */
    private Integer toped;

    /**
     * 标签信息
     */
    private String tags;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 套餐主键
     */
    private String skuId;

    /**
     * 价格
     */
    private String skuPrice;

    /**
     * 分成
     */
    private String skuPmoney;

    /**
     * 商户编号
     */
    private String customerId;

    /**
     * 商户名称
     */
    private String customerName;

    /**
     * 商户等级 0 非认证商户 1认证商户V1 2认证商户V2  3认证商户V3
     */
    private Integer level;


}
