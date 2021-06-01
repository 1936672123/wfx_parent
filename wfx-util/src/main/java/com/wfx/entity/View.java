package com.wfx.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author jobob
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("order_view")
public class View implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Integer oid;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 下单IP
     */
    private String orderIp;

    /**
     * 代理用户(memeber_id)
     */
    private String userId;

    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date orderTime;

    /**
     * 下单类型  0 正常下单 1 代客录单 2 异常订单
     */
    private Integer orderType;

    /**
     * 购买数量
     */
    private Integer buyNum;

    /**
     * 状态 0 未下单，1 已下单
     */
    private Integer state;

    /**
     * 选择的套餐
     */
    private String skuId;

    /**
     * 商品编号
     */
    private String goodId;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 套餐名称
     */
    private String skuName;

    /**
     * 账号
     */
    private String account;

    /**
     * QQ号码
     */
    private String qqNum;

    /**
     * 收件人姓名
     */
    private String addName;

    /**
     * 收件人电话
     */
    private String addTel;

    /**
     * 详细地址
     */
    private String addDetail;

    @TableField(exist=false)
    private Date startTime;

    @TableField(exist=false)
    private Date endTime;


}
