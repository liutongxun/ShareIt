package com.liu.auth.infra.basic.service;

import com.liu.auth.infra.basic.entity.AuthUserRole;
/**
 * Service interface for AuthUserRole operations.
 *
 * <p>This interface defines methods for creating, retrieving, updating,
 * and deleting user-role association records within the authorization system.</p>
 *
 * @author Liu
 * @since 2025/09/09
 */
public interface AuthUserRoleService {

    /**
     * Retrieve a single AuthUserRole by its primary key.
     *
     * @param id the primary key of the user-role mapping
     * @return the AuthUserRole instance, or null if not found
     */
    AuthUserRole queryById(Long id);

    /**
     * Insert a new AuthUserRole record.
     *
     * @param authUserRole the AuthUserRole instance to insert
     * @return the inserted AuthUserRole instance (with generated ID if applicable)
     */
    AuthUserRole insert(AuthUserRole authUserRole);

    /**
     * Update an existing AuthUserRole record.
     *
     * @param authUserRole the AuthUserRole instance containing updated data
     * @return the updated AuthUserRole instance fetched from the database
     */
    AuthUserRole update(AuthUserRole authUserRole);

    /**
     * Delete a single AuthUserRole record by its primary key.
     *
     * @param id the primary key of the user-role mapping to delete
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteById(Long id);
}
