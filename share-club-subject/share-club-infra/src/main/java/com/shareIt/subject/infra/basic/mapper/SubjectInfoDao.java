package com.shareIt.subject.infra.basic.mapper;

import com.shareIt.subject.infra.basic.entity.SubjectInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Data Access Layer for the Subject Information Table (SubjectInfo)
 *
 * Provides methods for CRUD operations and custom queries on the subject_info table.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectInfoDao {

    /**
     * Query a single record by its primary key.
     *
     * @param id Primary key
     * @return Instance of SubjectInfo corresponding to the given ID
     */
    SubjectInfo queryById(Long id);

    /**
     * Query a paginated set of records matching the given conditions.
     *
     * @param subjectInfo Filtering criteria encapsulated in a SubjectInfo object
     * @return List of SubjectInfo instances matching the criteria
     */
    List<SubjectInfo> queryAllByLimit(SubjectInfo subjectInfo);

    /**
     * Count total number of rows that match the given conditions.
     *
     * @param subjectInfo Filtering criteria encapsulated in a SubjectInfo object
     * @return Total row count
     */
    long count(SubjectInfo subjectInfo);

    /**
     * Insert a new record into the subject_info table.
     *
     * @param subjectInfo Instance to insert
     * @return Number of rows affected
     */
    int insert(SubjectInfo subjectInfo);

    /**
     * Insert multiple records in a batch using MyBatis's native foreach method.
     *
     * @param entities List of SubjectInfo instances to insert
     * @return Number of rows affected
     */
    int insertBatch(@Param("entities") List<SubjectInfo> entities);

/**
 * Insert or update multiple records in a batch, based on primary key.
 * Uses MyBatis's native foreach method.
 *
 * @param entities List of SubjectInfo instances to upsert
 * @return Number of rows affected
*/

}