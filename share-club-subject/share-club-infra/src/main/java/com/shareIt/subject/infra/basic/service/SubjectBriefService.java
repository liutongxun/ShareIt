package com.shareIt.subject.infra.basic.service;


import com.shareIt.subject.infra.basic.entity.SubjectBrief;

/**
 * Service Interface for the Essay Question (SubjectBrief) Table
 *
 * Defines methods for CRUD operations on subject_brief data.
 *
 * Author: Liu Tongxun
 * Since: 2025/06/01
 */
public interface SubjectBriefService {


    /**
     * Add new data
     *
     * @param subjectBrief Instance object
     * @return Instance object
     */
    SubjectBrief insert(SubjectBrief subjectBrief);


    /**
     * Query a subject brief based on specific conditions.
     * This method retrieves a SubjectBrief object that matches the provided criteria.
     *
     * @param subjectBrief an object containing the query conditions (e.g., subjectId, label, status)
     * @return the SubjectBrief that matches the specified conditions, or null if no match is found
     */
    SubjectBrief queryByCondition(SubjectBrief subjectBrief);
}
