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
public class WxbGoodAttribute implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "attr_id", type = IdType.AUTO)
    private Integer attrId;

    private Integer catId;

    private String attrValues;

    private String attrName;

    private String goodsId;

    private Integer paixu;


}
