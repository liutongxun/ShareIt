package com.liu.auth.infra.basic.mapper;

import com.liu.auth.infra.basic.entity.AuthPermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * Data Access Object (DAO) for the AuthPermission table.
 *
 * <p>This interface defines CRUD operations and batch methods for the AuthPermission
 * entity, which represents permissions within the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/10
 */
public interface AuthPermissionDao {

    /**
     * Retrieve a single AuthPermission record by its primary key.
     *
     * @param id the primary key of the permission record
     * @return the AuthPermission instance, or null if not found
     */
    AuthPermission queryById(Long id);

    /**
     * Query a list of AuthPermission records matching the given example criteria,
     * with optional limits for pagination.
     *
     * @param authPermission an example AuthPermission containing filter criteria
     * @return a list of matching AuthPermission instances
     */
    List<AuthPermission> queryAllByLimit(AuthPermission authPermission);

    /**
     * Count the total number of AuthPermission records matching the given example criteria.
     *
     * @param authPermission an example AuthPermission containing filter criteria
     * @return the total count of matching records
     */
    long count(AuthPermission authPermission);

    /**
     * Insert a new AuthPermission record.
     *
     * @param authPermission the AuthPermission instance to insert
     * @return the number of rows affected
     */
    int insert(AuthPermission authPermission);

    /**
     * Insert multiple AuthPermission records in a batch.
     *
     * @param entities a list of AuthPermission instances to insert
     * @return the number of rows affected
     */
    int insertBatch(@Param("entities") List<AuthPermission> entities);

    /**
     * Insert or update multiple AuthPermission records in a batch.
     * Uses MyBatis foreach to iterate over the list.
     *
     * @param entities a list of AuthPermission instances to insert or update
     * @return the number of rows affected
     * @throws org.springframework.jdbc.BadSqlGrammarException if the input list is empty
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthPermission> entities);

    /**
     * Update an existing AuthPermission record.
     *
     * @param authPermission the AuthPermission instance containing updated data
     * @return the number of rows affected
     */
    int update(AuthPermission authPermission);

    /**
     * Delete a single AuthPermission record by its primary key.
     *
     * @param id the primary key of the permission record to delete
     * @return the number of rows affected
     */
    int deleteById(Long id);

    /**
     * Retrieve a list of AuthPermission records associated with the given roles.
     *
     * @param roleIdList a list of role IDs to query permissions for
     * @return a list of matching AuthPermission instances
     */
    List<AuthPermission> queryByRoleList(@Param("list") List<Long> roleIdList);

}
