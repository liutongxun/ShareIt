package com.liu.auth.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * User information DTO (Data Transfer Object)
 *
 * @author Liu Tongxun
 * @since 2025/08/25
 */
@Data
public class AuthUserDTO implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private String email;

    private String phone;

    private String password;

    private Integer sex;

    private String avatar;

    private Integer status;

    private String introduce;

    private String extJson;

}

