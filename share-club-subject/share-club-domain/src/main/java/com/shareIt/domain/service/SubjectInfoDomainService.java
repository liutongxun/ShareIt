package com.shareIt.domain.service;


import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.subject.common.entity.PageResult;

/**
 * Subject Domain Service
 *
 * Provides core business operations related to subject management, such as creation,
 * querying, pagination, and full-text search.
 *
 * Author: Liu Tongxun
 * Date: 2025/06/01
 */
public interface SubjectInfoDomainService {

    /**
     * Add a new subject
     *
     * @param subjectInfoBO The business object containing subject details to be added
     */
    void add(SubjectInfoBO subjectInfoBO);


    /**
     * Paginated query for subject information
     *
     * @param subjectInfoBO The business object containing query parameters
     * @return A paginated result set of subject information
     */
    PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO);


    /**
     * Queries subject information based on the provided SubjectInfoBO object.
     *
     * @param subjectInfoBO The Business Object (BO) containing the subject query parameters.
     * @return The SubjectInfoBO containing the subject details retrieved based on the query parameters.
     */
    SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO);

}

