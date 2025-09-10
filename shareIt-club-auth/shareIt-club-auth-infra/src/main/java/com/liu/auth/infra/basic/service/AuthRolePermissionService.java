package com.liu.auth.infra.basic.service;

import com.liu.auth.infra.basic.entity.AuthRolePermission;


import java.util.List;
/**
 * Service interface for AuthRolePermission operations.
 *
 * <p>This interface defines methods for CRUD operations and batch insertion
 * related to the mapping between roles and permissions in the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/10
 */
public interface AuthRolePermissionService {

    /**
     * Retrieve a single AuthRolePermission record by its primary key.
     *
     * @param id the primary key of the role-permission mapping
     * @return the AuthRolePermission instance, or null if not found
     */
    AuthRolePermission queryById(Long id);

    /**
     * Insert a new AuthRolePermission record.
     *
     * @param authRolePermission the instance to insert
     * @return the inserted AuthRolePermission instance (with generated ID if applicable)
     */
    AuthRolePermission insert(AuthRolePermission authRolePermission);

    /**
     * Insert multiple AuthRolePermission records in a batch.
     *
     * @param authRolePermissionList a list of instances to insert
     * @return the number of rows affected
     */
    int batchInsert(List<AuthRolePermission> authRolePermissionList);

    /**
     * Update an existing AuthRolePermission record.
     *
     * @param authRolePermission the instance containing updated data
     * @return the updated AuthRolePermission instance fetched from the database
     */
    AuthRolePermission update(AuthRolePermission authRolePermission);

    /**
     * Delete a single AuthRolePermission record by its primary key.
     *
     * @param id the primary key of the record to delete
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteById(Long id);

    /**
     * Query AuthRolePermission records matching the given example criteria.
     *
     * @param authRolePermission an example instance containing filter criteria
     * @return a list of matching AuthRolePermission instances
     */
    List<AuthRolePermission> queryByCondition(AuthRolePermission authRolePermission);

}
