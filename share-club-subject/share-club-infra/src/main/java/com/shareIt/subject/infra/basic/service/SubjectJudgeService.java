package com.shareIt.subject.infra.basic.service;

import com.shareIt.subject.infra.basic.entity.SubjectJudge;
import com.shareIt.subject.infra.basic.entity.SubjectLabel;

import java.util.List;

/**
 * Service Interface for the True/False Question (SubjectJudge) Table
 *
 * Defines methods for CRUD operations on subject_judge data.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectJudgeService {

    /**
     * Add new data
     *
     * @param subjectJudge Instance object
     * @return Instance object
     */
    SubjectJudge insert(SubjectJudge subjectJudge);


    List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge);
}
