package com.liu.auth.domain.service;

import com.liu.auth.domain.entity.AuthPermissionBO;

import java.util.List;

/**
 * Role Domain Service
 *
 * @author Liu Tongxun
 * @date 2025/09/10
 */
public interface AuthPermissionDomainService {

    Boolean add(AuthPermissionBO authPermissionBO);

    Boolean update(AuthPermissionBO authPermissionBO);

    Boolean delete(AuthPermissionBO authPermissionBO);

    List<String> getPermission(String userName);
}
