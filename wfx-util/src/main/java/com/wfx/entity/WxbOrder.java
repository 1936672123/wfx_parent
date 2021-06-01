package com.wfx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-10-26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WxbOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "oid", type = IdType.AUTO)
    private Integer oid;

    /**
     * 订单编号
     */
    private String orderId;

    /**
     * 商品编号
     */
    private String goodId;

    /**
     * 购买数量
     */
    private Integer buyNum;

    /**
     * 下单时间
     */
    private Date orderTime;

    /**
     * 渠道编号
     */
    private String channelId;

    /**
     * 状态 0 未下单，1 已下单
     */
    private Integer state;

    /**
     * 省份
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 地区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 留言
     */
    private String buyerReamrk;

    /**
     * 买家电话
     */
    private String buyerPhone;

    /**
     * 支付方式
     */
    private Integer payType;

    /**
     * 买家姓名
     */
    private String buyerName;

    /**
     * 选择的套餐
     */
    private String skuId;

    /**
     * 代理用户(memeber_id)
     */
    private String userId;

    /**
     * 快递单号
     */
    private String courierId;

    /**
     * 备注信息
     */
    private String orderRemark;

    /**
     * 快递公司
     */
    private String senderType;

    /**
     * 下单类型  0 正常下单 1 代客录单 2 异常订单
     */
    private Integer orderType;

    /**
     * 后台备注
     */
    private String adminRemark;

    /**
     * 审核人员
     */
    private String operator;

    /**
     * 订单审核时间
     */
    private Date checkTime;

    /**
     * 下单IP
     */
    private String orderIp;

    /**
     * 最后修改时间
     */
    private Date updateTime;

    /**
     * 支付宝支付状态，未支付为0，已支付为1
     */
    private String alipayState;


}
