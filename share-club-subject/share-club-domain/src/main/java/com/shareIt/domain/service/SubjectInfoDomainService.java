package com.shareIt.domain.service;


import com.shareIt.domain.entity.SubjectInfoBO;

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


}
