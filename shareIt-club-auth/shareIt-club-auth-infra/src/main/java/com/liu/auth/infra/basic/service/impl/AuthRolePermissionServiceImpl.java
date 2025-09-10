package com.liu.auth.infra.basic.service.impl;

import com.liu.auth.infra.basic.entity.AuthRolePermission;
import com.liu.auth.infra.basic.mapper.AuthRolePermissionDao;
import com.liu.auth.infra.basic.service.AuthRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service implementation for handling AuthRolePermission operations.
 *
 * <p>This class provides the concrete implementation of the AuthRolePermissionService
 * interface, delegating CRUD and batch methods to the underlying AuthRolePermissionDao.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/10
 */
@Service("authRolePermissionService")
public class AuthRolePermissionServiceImpl implements AuthRolePermissionService {
    @Resource
    private AuthRolePermissionDao authRolePermissionDao;

    /**
     * Retrieve a single AuthRolePermission record by its primary key.
     *
     * @param id the primary key of the role-permission mapping
     * @return the AuthRolePermission instance, or null if not found
     */
    @Override
    public AuthRolePermission queryById(Long id) {
        return this.authRolePermissionDao.queryById(id);
    }

    /**
     * Insert a new AuthRolePermission record.
     *
     * @param authRolePermission the AuthRolePermission instance to insert
     * @return the inserted AuthRolePermission instance (with generated ID if applicable)
     */
    @Override
    public AuthRolePermission insert(AuthRolePermission authRolePermission) {
        this.authRolePermissionDao.insert(authRolePermission);
        return authRolePermission;
    }

    /**
     * Insert multiple AuthRolePermission records in a batch.
     *
     * @param authRolePermissionList a list of AuthRolePermission instances to insert
     * @return the number of rows affected
     */
    @Override
    public int batchInsert(List<AuthRolePermission> authRolePermissionList) {
        return this.authRolePermissionDao.insertBatch(authRolePermissionList);
    }

    /**
     * Update an existing AuthRolePermission record.
     *
     * @param authRolePermission the AuthRolePermission instance containing updated data
     * @return the updated AuthRolePermission instance fetched from the database
     */
    @Override
    public AuthRolePermission update(AuthRolePermission authRolePermission) {
        this.authRolePermissionDao.update(authRolePermission);
        return this.queryById(authRolePermission.getId());
    }

    /**
     * Delete a single AuthRolePermission record by its primary key.
     *
     * @param id the primary key of the role-permission mapping to delete
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authRolePermissionDao.deleteById(id) > 0;
    }

    /**
     * Query AuthRolePermission records matching the given example criteria,
     * with optional limits for pagination.
     *
     * @param authRolePermission an example AuthRolePermission containing filter criteria
     * @return a list of matching AuthRolePermission instances
     */
    @Override
    public List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission) {
        return this.authRolePermissionDao.queryAllByLimit(authRolePermission);
    }
}
