package com.wfx.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class WxbGoodType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型编号
     */
    @TableId
    private String typeId;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 上级编号
     */
    private String parentId;

    /**
     * 类型标签
     */
    private String typeTag;

    /**
     * 排序编号
     */
    private Integer orderNo;

    /**
     * 分类助记码
     */
    private String alisaCode;


}
