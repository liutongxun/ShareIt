package com.liu.auth.infra.basic.mapper;

import com.liu.auth.infra.basic.entity.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Data Access Object (DAO) for the AuthUser table.
 *
 * <p>This interface defines CRUD operations and batch methods for the AuthUser
 * entity, which represents user profiles within the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/08/25
 */
public interface AuthUserDao {

    /**
     * Retrieve a single AuthUser record by its primary key.
     *
     * @param id the primary key of the user record
     * @return the AuthUser instance, or null if not found
     */
    AuthUser queryById(Long id);

    /**
     * Query a list of AuthUser records matching the given example criteria,
     * with optional limits for pagination.
     *
     * @param authUser an example AuthUser containing filter criteria
     * @return a list of matching AuthUser instances
     */
    List<AuthUser> queryAllByLimit(AuthUser authUser);

    /**
     * Count the total number of AuthUser records matching the given example criteria.
     *
     * @param authUser an example AuthUser containing filter criteria
     * @return the total count of matching records
     */
    long count(AuthUser authUser);

    /**
     * Insert a new AuthUser record.
     *
     * @param authUser the AuthUser instance to insert
     * @return the number of rows affected
     */
    int insert(AuthUser authUser);

    /**
     * Insert multiple AuthUser records in a batch.
     *
     * @param entities a list of AuthUser instances to insert
     * @return the number of rows affected
     */
    int insertBatch(@Param("entities") List<AuthUser> entities);

    /**
     * Insert or update multiple AuthUser records in a batch.
     * Uses MyBatis foreach to iterate over the list.
     *
     * @param entities a list of AuthUser instances to insert or update
     * @return the number of rows affected
     * @throws org.springframework.jdbc.BadSqlGrammarException if the input list is empty
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthUser> entities);

    /**
     * Update an existing AuthUser record.
     *
     * @param authUser the AuthUser instance containing updated data
     * @return the number of rows affected
     */
    int update(AuthUser authUser);

    /**
     * Delete a single AuthUser record by its primary key.
     *
     * @param id the primary key of the user record to delete
     * @return the number of rows affected
     */
    int deleteById(Long id);

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
     * @param userNameList a list of usernames to query
     * @return a list of matching AuthUser instances
     */
    List<AuthUser> listUserInfoByIds(@Param("userNameList") List<String> userNameList);
}
