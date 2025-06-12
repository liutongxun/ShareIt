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
     * Counts the number of subjects that match the specified conditions.
     *
     * @param subjectInfo The subject information used as filter criteria (annotated as "subjectInfo").
     * @param categoryId The ID of the category to filter by (annotated as "categoryId").
     * @param labelId The ID of the label to filter by (annotated as "labelId").
     * @return The total number of subjects that meet the conditions.
     */
    int countByCondition(@Param("subjectInfo") SubjectInfo subjectInfo,
                         @Param("categoryId") Long categoryId,
                         @Param("labelId") Long labelId);

    /**
     * Retrieves a paginated list of subjects based on the specified filter conditions.
     *
     * @param subjectInfo The subject filter criteria (annotated as "subjectInfo").
     * @param categoryId The ID of the category to filter by (annotated as "categoryId").
     * @param labelId The ID of the label to filter by (annotated as "labelId").
     * @param start The starting index for pagination (annotated as "start").
     * @param pageSize The number of records to retrieve per page (annotated as "pageSize").
     * @return A list of SubjectInfo objects that match the given criteria within the specified page range.
     */
    List<SubjectInfo> queryPage(@Param("subjectInfo") SubjectInfo subjectInfo,
                                @Param("categoryId") Long categoryId,
                                @Param("labelId") Long labelId,
                                @Param("start") int start,
                                @Param("pageSize") Integer pageSize);

}