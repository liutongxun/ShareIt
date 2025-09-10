package com.liu.auth.infra.basic.mapper;

import com.liu.auth.infra.basic.entity.AuthRolePermission;
import org.apache.ibatis.annotations.Param;
import java.util.List;
/**
 * Data Access Object (DAO) for the AuthRolePermission table.
 *
 * <p>This interface defines CRUD operations and batch methods for
 * the AuthRolePermission entity, which represents the association
 * between roles and permissions in the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/10
 */
public interface AuthRolePermissionDao {

    /**
     * Retrieve a single AuthRolePermission record by its primary key.
     *
     * @param id the primary key of the record
     * @return the AuthRolePermission instance, or null if not found
     */
    AuthRolePermission queryById(Long id);

    /**
     * Query a list of AuthRolePermission records matching the given example,
     * with optional limits for pagination.
     *
     * @param authRolePermission an example entity containing filter criteria
     * @return a list of matching AuthRolePermission instances
     */
    List<AuthRolePermission> queryAllByLimit(AuthRolePermission authRolePermission);

    /**
     * Count the total number of AuthRolePermission records matching the given example.
     *
     * @param authRolePermission an example entity containing filter criteria
     * @return the total count of matching records
     */
    long count(AuthRolePermission authRolePermission);

    /**
     * Insert a new AuthRolePermission record.
     *
     * @param authRolePermission the instance to insert
     * @return the number of rows affected
     */
    int insert(AuthRolePermission authRolePermission);

    /**
     * Insert multiple AuthRolePermission records in a batch.
     *
     * @param entities a list of instances to insert
     * @return the number of rows affected
     */
    int insertBatch(@Param("entities") List<AuthRolePermission> entities);

    /**
     * Insert or update multiple AuthRolePermission records in a batch.
     * Uses MyBatis foreach to iterate over the list.
     *
     * @param entities a list of instances to insert or update
     * @return the number of rows affected
     * @throws org.springframework.jdbc.BadSqlGrammarException if the input list is empty
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthRolePermission> entities);

    /**
     * Update an existing AuthRolePermission record.
     *
     * @param authRolePermission the instance containing updated data
     * @return the number of rows affected
     */
    int update(AuthRolePermission authRolePermission);

    /**
     * Delete a single AuthRolePermission record by its primary key.
     *
     * @param id the primary key of the record to delete
     * @return the number of rows affected
     */
    int deleteById(Long id);

}
