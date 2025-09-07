package com.liu.auth.infra.basic.mapper;

import com.liu.auth.infra.basic.entity.AuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Data Access Object (DAO) for the AuthRole table.
 *
 * <p>This interface defines CRUD operations and batch methods for the AuthRole
 * entity, which represents roles within the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/07
 */
public interface AuthRoleDao {

    /**
     * Retrieve a single AuthRole record by its primary key.
     *
     * @param id the primary key of the role record
     * @return the AuthRole instance, or null if not found
     */
    AuthRole queryById(Long id);

    /**
     * Query a list of AuthRole records matching the given example criteria,
     * with optional limits for pagination.
     *
     * @param authRole an example AuthRole containing filter criteria
     * @return a list of matching AuthRole instances
     */
    List<AuthRole> queryAllByLimit(AuthRole authRole);

    /**
     * Count the total number of AuthRole records matching the given example criteria.
     *
     * @param authRole an example AuthRole containing filter criteria
     * @return the total count of matching records
     */
    long count(AuthRole authRole);

    /**
     * Insert a new AuthRole record.
     *
     * @param authRole the AuthRole instance to insert
     * @return the number of rows affected
     */
    int insert(AuthRole authRole);

    /**
     * Insert multiple AuthRole records in a batch.
     *
     * @param entities a list of AuthRole instances to insert
     * @return the number of rows affected
     */
    int insertBatch(@Param("entities") List<AuthRole> entities);

    /**
     * Insert or update multiple AuthRole records in a batch.
     * Uses MyBatis foreach to iterate over the list.
     *
     * @param entities a list of AuthRole instances to insert or update
     * @return the number of rows affected
     * @throws org.springframework.jdbc.BadSqlGrammarException if the input list is empty
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthRole> entities);

    /**
     * Update an existing AuthRole record.
     *
     * @param authRole the AuthRole instance containing updated data
     * @return the number of rows affected
     */
    int update(AuthRole authRole);

    /**
     * Delete a single AuthRole record by its primary key.
     *
     * @param id the primary key of the role record to delete
     * @return the number of rows affected
     */
    int deleteById(Long id);

    /**
     * Retrieve a list of AuthRole records by their primary keys.
     *
     * @param roleIdList a list of role IDs to query
     * @return a list of matching AuthRole instances
     */
    List<AuthRole> queryByRoleList(@Param("list") List<Long> roleIdList);

}
