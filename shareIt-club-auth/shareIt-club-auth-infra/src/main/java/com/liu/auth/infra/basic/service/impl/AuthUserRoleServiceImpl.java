package com.liu.auth.infra.basic.service.impl;

import com.liu.auth.infra.basic.entity.AuthUserRole;
import com.liu.auth.infra.basic.mapper.AuthUserRoleDao;
import com.liu.auth.infra.basic.service.AuthUserRoleService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
/**
 * Service implementation for handling AuthUserRole operations.
 *
 * <p>This class provides the concrete implementation of the AuthUserRoleService
 * interface, delegating CRUD methods to the underlying AuthUserRoleDao.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/09
 */
@Service("authUserRoleService")
public class AuthUserRoleServiceImpl implements AuthUserRoleService {
    @Resource
    private AuthUserRoleDao authUserRoleDao;

    /**
     * Retrieve a single AuthUserRole by its primary key.
     *
     * @param id the primary key of the user-role mapping
     * @return the AuthUserRole instance, or null if not found
     */
    @Override
    public AuthUserRole queryById(Long id) {
        return this.authUserRoleDao.queryById(id);
    }

    /**
     * Insert a new AuthUserRole record.
     *
     * @param authUserRole the AuthUserRole instance to insert
     * @return the inserted AuthUserRole instance (with generated ID if applicable)
     */
    @Override
    public AuthUserRole insert(AuthUserRole authUserRole) {
        this.authUserRoleDao.insert(authUserRole);
        return authUserRole;
    }

    /**
     * Update an existing AuthUserRole record.
     *
     * @param authUserRole the AuthUserRole instance containing updated data
     * @return the updated AuthUserRole instance fetched from the database
     */
    @Override
    public AuthUserRole update(AuthUserRole authUserRole) {
        this.authUserRoleDao.update(authUserRole);
        return this.queryById(authUserRole.getId());
    }

    /**
     * Delete a single AuthUserRole by its primary key.
     *
     * @param id the primary key of the user-role mapping to delete
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authUserRoleDao.deleteById(id) > 0;
    }
}
