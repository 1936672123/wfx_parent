package com.wfx.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jobob
 * @since 2020-10-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("good_sku_view")
public class SkuView implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private String goodId;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 加入时间
     */
    private Date createTime;

    /**
     * 是否推荐 0 否 1 是
     */
    private Integer recomed;

    /**
     * 是否置顶 0 取消置顶 1 置顶
     */
    private Integer toped;

    /**
     * 是否有效 0 待审核 1 已上架 2 已下架
     */
    private Integer state;

    /**
     * 价格
     */
    private String skuPrice;

    /**
     * 分成
     */
    private String skuPmoney;



}
