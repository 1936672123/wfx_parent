package com.wfx.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class WxbCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商户编号
     */
    private String customerId;

    /**
     * 商户名称
     */
    private String customerName;

    /**
     * 商户QQ
     */
    @TableField("QQ")
    private String qq;

    /**
     * 微信号码
     */
    private String wxh;

    /**
     * 电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 登录账户
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 是否有效 0 无效 1 有效
     */
    private Integer state;

    /**
     * 商户等级 0 非认证商户 1认证商户V1 2认证商户V2  3认证商户V3
     */
    private Integer level;

    private Double accBalance;

    /**
     * 最后登录时间
     */
    private Date updateTime;

    /**
     * 商户网址
     */
    private String website;


}
