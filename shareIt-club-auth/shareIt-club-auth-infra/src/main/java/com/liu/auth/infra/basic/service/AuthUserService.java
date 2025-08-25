package com.liu.auth.infra.basic.service;

import com.liu.auth.infra.basic.entity.AuthUser;

import java.util.List;

/**
 * Service interface for AuthUser operations.
 *
 * <p>This interface defines methods for CRUD operations and queries
 * related to user entities within the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/08/25
 */
public interface AuthUserService {

    /**
     * Retrieve a single AuthUser by its primary key.
     *
     * @param id the primary key of the user
     * @return the AuthUser instance, or null if not found
     */
    AuthUser queryById(Long id);

    /**
     * Insert a new AuthUser record.
     *
     * @param authUser the AuthUser instance to insert
     * @return the number of rows affected (typically 1 if successful)
     */
    Integer insert(AuthUser authUser);

    /**
     * Update an existing AuthUser record.
     *
     * @param authUser the AuthUser instance containing updated data
     * @return the number of rows affected (typically 1 if successful)
     */
    Integer update(AuthUser authUser);

    /**
     * Delete a single AuthUser by its primary key.
     *
     * @param id the primary key of the user to delete
     * @return true if the deletion was successful, false otherwise
     */
    boolean deleteById(Long id);

    /**
     * Query AuthUser records matching the given example criteria.
     *
     * @param authUser an example AuthUser containing filter criteria
     * @return a list of matching AuthUser instances
     */
    List<AuthUser> queryByCondition(AuthUser authUser);

    /**
     * Update a user record identified by its username.
     *
     * @param authUser the AuthUser instance containing the username and new data
     * @return the number of rows affected
     */
    Integer updateByUserName(AuthUser authUser);

    /**
     * Retrieve a list of AuthUser records by their usernames.
     *
     * @param ids a list of usernames to query
     * @return a list of matching AuthUser instances
     */
    List<AuthUser> listUserInfoByIds(List<String> ids);

}
