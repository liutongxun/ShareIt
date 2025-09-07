package com.liu.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * role bo
 *
 * @author: Liu Tongxun
 * @since 2025/09/07
 */
@Data
public class AuthRoleBO implements Serializable {

    private Long id;
    
    private String roleName;
    
    private String roleKey;

}

