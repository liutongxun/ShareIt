package com.shareIt.subject.infra.basic.service;


import com.shareIt.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
 * Subject Label Service Interface
 *
 * Defines the service layer methods for the SubjectLabel entity.
 *
 * @author Liu Tongxun
 * @since 2025-05-31
 */
public interface SubjectLabelService {


    int insert(SubjectLabel subjectLabel);

    /**
     * Modify data
     *
     * @param subjectLabel The SubjectLabel instance
     * @return Number of rows affected
     */
    int update(SubjectLabel subjectLabel);

}
