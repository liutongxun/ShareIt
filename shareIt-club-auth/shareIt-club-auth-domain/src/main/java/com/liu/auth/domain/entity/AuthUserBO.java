package com.liu.auth.domain.entity;



import lombok.Data;

import java.io.Serializable;

/**
 * User Information DTO (Data Transfer Object)
 *
 * @author Liu Tongxun
 * @date 2025/08/25
 */
@Data
public class AuthUserBO implements Serializable {

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

