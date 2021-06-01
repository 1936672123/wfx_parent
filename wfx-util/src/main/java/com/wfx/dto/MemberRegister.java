package com.wfx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRegister {

    private String account;
    private String password;
    private String rePassword;
    private String phone;
    private String code;

}
