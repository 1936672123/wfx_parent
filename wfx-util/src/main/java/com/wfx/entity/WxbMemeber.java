package com.wfx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-10-19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WxbMemeber implements Serializable {

    private static final long serialVersionUID = 1L;


    /**
     * MID
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    /**
     * 会员主键
     */
    private String memeberId;

    /**
     * 账号
     */
    private String account;

    /**
     * QQ号码
     */
    private String qqNum;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 推荐人ID 默认管理员
     */
    private String recomUser;

    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date registerTime;

    /**
     * 支付宝账号
     */
    private String payAccount;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 邀请码
     */
    private String visitCode;

    /**
     * 是否有邀请权限 0 没有 1 有
     */
    private Integer useRecom;

    /**
     * 层级关系识别码
     */
    private String levelCode;



    /**
     * 最后登录时间
     */
    private Date updateTime;


    @TableField(exist = false)
    private String startTime;

    @TableField(exist=false)
    private String endTime;


}
