package com.wfx.dto;

import com.wfx.entity.WxbGood;
import com.wfx.entity.WxbGoodSku;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodDTO {

    private WxbGood goods;

    private List<WxbGoodSku> goodSkus;

}
