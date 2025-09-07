package com.liu.auth.infra.basic.service;

import com.liu.auth.infra.basic.entity.AuthRole;

import java.util.List;
/**
 * Service interface for AuthRole operations.
 *
 * <p>This interface defines methods for CRUD operations and queries
 * related to role entities within the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
public interface AuthRoleService {

    /**
     * Retrieve a single AuthRole by its primary key.
     *
     * @param id the primary key of the role
     * @return the AuthRole instance, or null if not found
     */
    AuthRole queryById(Long id);

    /**
     * Insert a new AuthRole record.
     *
     * @param authRole the AuthRole instance to insert
     * @return the number of rows affected (typically 1 if successful)
     */
    int insert(AuthRole authRole);

    /**
     * Update an existing AuthRole record.
     *
     * @param authRole the AuthRole instance containing updated data
     * @return the number of rows affected (typically 1 if successful)
     */
    int update(AuthRole authRole);

    /**
     * Delete a single AuthRole by its primary key.
     *
     * @param id the primary key of the role to delete
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteById(Long id);

    /**
     * Retrieve a single AuthRole matching the given example criteria.
     *
     * @param authRole an example AuthRole containing filter criteria
     * @return the first matching AuthRole instance, or null if none found
     */
    AuthRole queryByCondition(AuthRole authRole);

    /**
     * Retrieve a list of AuthRole records by their primary keys.
     *
     * @param roleIdList a list of role IDs to query
     * @return a list of matching AuthRole instances
     */
    List<AuthRole> queryByRoleList(List<Long> roleIdList);
}
