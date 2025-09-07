package com.liu.auth.application.dto;


import lombok.Data;

import java.io.Serializable;

/**
 * Role Data Transfer Object (DTO)
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
@Data
public class AuthRoleDTO implements Serializable {

    private Long id;

    private String roleName;

    private String roleKey;

}
