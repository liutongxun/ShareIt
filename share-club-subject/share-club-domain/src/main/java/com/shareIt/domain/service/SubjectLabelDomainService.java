package com.shareIt.domain.service;


import com.shareIt.domain.entity.SubjectLabelBO;

import java.util.List;

/**
 * Subject Label Domain Service
 *
 * Provides domain-level operations for SubjectLabel entities.
 *
 * Author: Liu Tongxun
 * Date: 2025/05/30
 */
public interface SubjectLabelDomainService {

    /**
     * Add a new label
     *
     * @param subjectLabelBO Business object representing the label
     * @return True if the operation was successful, false otherwise
     */
    Boolean add(SubjectLabelBO subjectLabelBO);



}

