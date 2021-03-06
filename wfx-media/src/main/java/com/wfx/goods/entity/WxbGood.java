package com.wfx.goods.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

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
public class WxbGood implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId
    private String goodId;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品图片
     */
    private String goodPic;

    /**
     * 图片2
     */
    private String goodPic1;

    /**
     * 图片3
     */
    private String goodPic2;

    /**
     * 商户ID
     */
    private String customerId;

    /**
     * 推广说明
     */
    private String promoteDesc;

    /**
     * 文案ID
     */
    private String copyIds;

    /**
     * 文案说明
     */
    private String copyDesc;

    /**
     * 跳转链接
     */
    private String forwardLink;

    /**
     * 排序编号
     */
    private Integer orderNo;

    /**
     * 商品分类
     */
    private String typeId;

    /**
     * 标签信息
     */
    private String tags;

    /**
     * 是否有效 0 待审核 1 已上架 2 已下架
     */
    private Integer state;

    /**
     * 加入时间
     */
    private Date createTime;

    /**
     * 是否置顶 0 取消置顶 1 置顶
     */
    private Integer toped;

    /**
     * 是否推荐 0 否 1 是
     */
    private Integer recomed;

    /**
     * 置顶时间
     */
    private Date topedTime;

    /**
     * 推荐时间
     */
    private Date recomedTime;

    /**
     * 站内文案ID
     */
    private String spcId;

    /**
     * 空间文案ID
     */
    private String zonId;

    /**
     * 购买人数作弊值
     */
    private Integer sellNum;

    /**
     * 产品网址
     */
    private String website;

    /**
     * 客服QQ
     */
    private String kfqq;


}
