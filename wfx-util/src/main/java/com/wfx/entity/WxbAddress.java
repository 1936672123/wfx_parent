package com.wfx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class WxbAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "add_id", type = IdType.AUTO)
    private Integer addId;

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

    /**
     * 收件人邮箱
     */
    private String addEmail;

    /**
     * 地址别名（家里、公司、学校）
     */
    private String addAlias;

    /**
     * 是否默认0：否 1：是
     */
    private Integer addDefault;

    /**
     * 自媒体用户外键
     */
    private Integer memeberId;


}
