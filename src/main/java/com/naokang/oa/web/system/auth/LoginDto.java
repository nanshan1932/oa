package com.naokang.oa.web.system.auth;

import lombok.Data;

@Data
public class LoginDto {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
