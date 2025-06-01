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

    /**
     * Query labels based on the provided condition
     *
     * @param subjectLabel The SubjectLabel instance containing query criteria
     * @return A list of SubjectLabel matching the given criteria
     */
    List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel);

    /**
     * Retrieve multiple records by a list of IDs.
     *
     * @param labelIdList List of SubjectLabel IDs
     * @return List of matching SubjectLabel objects
     */
    List<SubjectLabel> batchQueryById(List<Long> labelIdList);

}
