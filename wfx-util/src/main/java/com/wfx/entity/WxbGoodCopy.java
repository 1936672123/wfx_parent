package com.wfx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxbGoodCopy implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文案ID
     */
    @TableId(value = "copy_id", type = IdType.AUTO)
    private Integer copyId;

    /**
     * 商品id
     */
    private String goodId;

    /**
     * 文案标题
     */
    private String copyTitle;

    /**
     * 文案链接
     */
    private String copyLink;

    /**
     * 文案内容
     */
    private String copyContent;

    /**
     * 商户编号
     */
    private String customerId;

    /**
     * 排序编号
     */
    private Integer orderNo;

    /**
     * 文案类型 0 微信文案 1 站内文案 2日志文案
     */
    private Integer typeId;

    private String restIds;

    private String imgUrls;


}
