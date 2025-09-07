package com.liu.auth.domain.service;

import com.liu.auth.domain.entity.AuthRoleBO;

/**
 * Role Domain Service
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
public interface AuthRoleDomainService {

    Boolean add(AuthRoleBO authRoleBO);

    Boolean update(AuthRoleBO authRoleBO);

    Boolean delete(AuthRoleBO authRoleBO);

}
