package com.liu.auth.domain.service;


import cn.dev33.satoken.stp.SaTokenInfo;
import com.liu.auth.domain.entity.AuthUserBO;

import java.util.List;

/**
 * User Domain Service
 *
 * @author Liu tongxun
 * @date 2025/08/25
 */
public interface AuthUserDomainService {

    /**
     * Register a new user
     *
     * @param authUserBO the business object containing user registration information
     * @return true if registration is successful, false otherwise
     */
    Boolean register(AuthUserBO authUserBO);

    /**
     * Update user information
     *
     * @param authUserBO the business object containing updated user information
     * @return true if update is successful, false otherwise
     */
    Boolean update(AuthUserBO authUserBO);

    /**
     * Delete user information
     *
     * @param authUserBO the business object containing user information to delete
     * @return true if deletion is successful, false otherwise
     */
    Boolean delete(AuthUserBO authUserBO);
}

