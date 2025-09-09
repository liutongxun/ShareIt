package com.liu.auth.infra.basic.mapper;

import com.liu.auth.infra.basic.entity.AuthUserRole;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * Data Access Object (DAO) for the AuthUserRole table.
 *
 * <p>This interface defines CRUD operations and batch methods for
 * the AuthUserRole entity, which represents the mapping between users
 * and roles in the authorization system.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/09
 */
public interface AuthUserRoleDao {

    /**
     * Retrieve a single AuthUserRole record by its primary key.
     *
     * @param id the primary key of the record
     * @return the AuthUserRole instance, or null if not found
     */
    AuthUserRole queryById(Long id);

    /**
     * Query a list of AuthUserRole records matching the given example,
     * with optional pagination limits.
     *
     * @param authUserRole an example entity containing filter criteria
     * @return a list of matching AuthUserRole instances
     */
    List<AuthUserRole> queryAllByLimit(AuthUserRole authUserRole);

    /**
     * Count the total number of AuthUserRole records matching the given example.
     *
     * @param authUserRole an example entity containing filter criteria
     * @return the total count of matching records
     */
    long count(AuthUserRole authUserRole);

    /**
     * Insert a new AuthUserRole record.
     *
     * @param authUserRole the instance to insert
     * @return the number of rows affected
     */
    int insert(AuthUserRole authUserRole);

    /**
     * Insert multiple AuthUserRole records in a batch.
     *
     * @param entities a list of instances to insert
     * @return the number of rows affected
     */
    int insertBatch(@Param("entities") List<AuthUserRole> entities);

    /**
     * Insert or update multiple AuthUserRole records in a batch.
     * Uses MyBatis foreach to iterate over the list.
     *
     * @param entities a list of instances to insert or update
     * @return the number of rows affected
     * @throws org.springframework.jdbc.BadSqlGrammarException if the input list is empty
     */
    int insertOrUpdateBatch(@Param("entities") List<AuthUserRole> entities);

    /**
     * Update an existing AuthUserRole record.
     *
     * @param authUserRole the instance containing updated data
     * @return the number of rows affected
     */
    int update(AuthUserRole authUserRole);

    /**
     * Delete a single AuthUserRole record by its primary key.
     *
     * @param id the primary key of the record to delete
     * @return the number of rows affected
     */
    int deleteById(Long id);

}
