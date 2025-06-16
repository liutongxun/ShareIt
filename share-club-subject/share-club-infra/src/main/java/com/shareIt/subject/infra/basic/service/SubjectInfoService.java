package com.shareIt.subject.infra.basic.service;


import com.shareIt.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * Service Interface for the Subject Information Table (SubjectInfo)
 *
 * Defines methods for CRUD operations and custom queries on subject_info data.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectInfoService {


    /**
     * Insert a new record
     *
     * @param subjectInfo the entity object to be inserted
     * @return the inserted entity object
     */
    SubjectInfo insert(SubjectInfo subjectInfo);

    /**
     * Counts the number of subjects that match the given conditions
     *
     * @param subjectInfo The subject entity containing filter criteria
     * @param categoryId The ID of the subject category
     * @param labelId The ID of the subject label
     * @return The total count of matching subjects
     */
    int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId);

    /**
     * Retrieves a paginated list of subjects based on the specified conditions.
     *
     * @param subjectInfo The subject information used as filter criteria.
     * @param categoryId The ID of the category to filter by.
     * @param labelId The ID of the label to filter by.
     * @param start The starting index of the records to retrieve.
     * @param pageSize The number of records to retrieve per page.
     * @return A list of subjects that match the specified conditions within the given page range.
     */
    List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize);


    /**
     * Query subject information by ID
     *
     * @param id the unique identifier of the subject
     * @return the subject information corresponding to the given ID
     */
    SubjectInfo queryById(Long id);

}
