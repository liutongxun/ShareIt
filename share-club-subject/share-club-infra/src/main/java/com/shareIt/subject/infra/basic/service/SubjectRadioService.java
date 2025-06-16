package com.shareIt.subject.infra.basic.service;


import com.shareIt.subject.infra.basic.entity.SubjectRadio;

import java.util.List;

/**
 * Service Interface for the Single Choice Question Table (SubjectRadio)
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectRadioService {

    /**
     * Batch insert multiple records
     *
     * @param subjectRadioList the list of SubjectRadio objects to be inserted
     */
    void batchInsert(List<SubjectRadio> subjectRadioList);

    List<SubjectRadio> queryByCondition(SubjectRadio subjectRadio);
}
