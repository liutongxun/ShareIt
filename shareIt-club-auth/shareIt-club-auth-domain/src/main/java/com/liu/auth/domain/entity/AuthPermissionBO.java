package com.liu.auth.domain.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * permission dto
 *
 * @author Liu Tongxun
 * @date 2025/09/10
 */
@Data
public class AuthPermissionBO implements Serializable {

    private Long id;
    
    private String name;
    
    private Long parentId;
    
    private Integer type;
    
    private String menuUrl;
    
    private Integer status;
    
    private Integer show;
    
    private String icon;
    
    private String permissionKey;
}

