package com.liu.auth.infra.basic.service.impl;

import com.liu.auth.infra.basic.entity.AuthRole;
import com.liu.auth.infra.basic.mapper.AuthRoleDao;
import com.liu.auth.infra.basic.service.AuthRoleService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
/**
 * Service implementation for handling AuthRole operations.
 *
 * <p>This class provides the concrete implementation of the AuthRoleService
 * interface, delegating CRUD and query methods to the underlying AuthRoleDao.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
@Service("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
    @Resource
    private AuthRoleDao authRoleDao;

    /**
     * Retrieve a single AuthRole record by its primary key.
     *
     * @param id the primary key of the role
     * @return the AuthRole instance, or null if not found
     */
    @Override
    public AuthRole queryById(Long id) {
        return this.authRoleDao.queryById(id);
    }

    /**
     * Insert a new AuthRole record.
     *
     * @param authRole the AuthRole instance to insert
     * @return the number of rows affected (typically 1 if successful)
     */
    @Override
    public int insert(AuthRole authRole) {
        return this.authRoleDao.insert(authRole);
    }

    /**
     * Update an existing AuthRole record.
     *
     * @param authRole the AuthRole instance containing updated data
     * @return the number of rows affected (typically 1 if successful)
     */
    @Override
    public int update(AuthRole authRole) {
        return this.authRoleDao.update(authRole);
    }

    /**
     * Delete a single AuthRole record by its primary key.
     *
     * @param id the primary key of the role to delete
     * @return true if the deletion was successful, false otherwise
     */
    @Override
    public boolean deleteById(Long id) {
        return this.authRoleDao.deleteById(id) > 0;
    }

    /**
     * Retrieve a single AuthRole record matching the given example criteria.
     *
     * @param authRole an example AuthRole containing filter criteria
     * @return the first matching AuthRole instance, or null if none found
     */
    @Override
    public AuthRole queryByCondition(AuthRole authRole) {
        return authRoleDao.queryAllByLimit(authRole).stream().findFirst().orElse(null);
    }

    /**
     * Retrieve a list of AuthRole records by their primary keys.
     *
     * @param roleIdList a list of role IDs to query
     * @return a list of matching AuthRole instances
     */
    @Override
    public List<AuthRole> queryByRoleList(List<Long> roleIdList) {
        return authRoleDao.queryByRoleList(roleIdList);
    }
}
