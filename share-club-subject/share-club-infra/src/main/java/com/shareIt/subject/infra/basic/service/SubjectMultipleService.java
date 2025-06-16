package com.shareIt.subject.infra.basic.service;


import com.shareIt.subject.infra.basic.entity.SubjectMultiple;

import java.util.List;

/**
 * Service Interface for the Multiple Choice Question Table (SubjectMultiple)
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */

public interface SubjectMultipleService {

    /**
     * Batch insert
     */
    void batchInsert(List<SubjectMultiple> subjectMultipleList);

    List<SubjectMultiple> queryByCondition(SubjectMultiple subjectMultiple);
}
