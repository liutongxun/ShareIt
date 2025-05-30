package com.shareIt.subject.infra.basic.mapper;

import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import org.apache.ibatis.annotations.Param;
 import java.util.List;

/**
 * Database access layer for the SubjectCategory table
 *
 * @author Liu Tongxun
 * @since 2025-05-21 14:58:00
 */
public interface SubjectCategoryDao {

    /**
     * Query a single record by ID
     *
     * @param id Primary key
     * @return The instance object
     */
    SubjectCategory queryById(Integer id);



    /**
     * Insert a new record
     *
     * @param subjectCategory The instance object
     * @return The number of affected rows
     */
    int insert(SubjectCategory subjectCategory);


    /**
     * Query primary categories
     *
     * @param subjectCategory The instance object containing query conditions
     * @return A list of SubjectCategory records
     */
    List<SubjectCategory>  queryPrimaryCategory(SubjectCategory subjectCategory);


    /**
     * Updates a SubjectCategory record.
     *
     * @param subjectCategory the SubjectCategory instance to update
     * @return the updated SubjectCategory instance
     */
    int update(SubjectCategory subjectCategory);

}

