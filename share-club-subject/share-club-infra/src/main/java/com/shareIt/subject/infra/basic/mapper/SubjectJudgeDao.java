package com.shareIt.subject.infra.basic.mapper;


import com.shareIt.subject.infra.basic.entity.SubjectJudge;

/**
 * Data Access Layer for the True/False Question (SubjectJudge) Table
 *
 * Provides methods for CRUD operations on the subject_judge table.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectJudgeDao {


    /**
     * Add new data
     *
     * @param subjectJudge Instance object
     * @return Number of affected rows
     */
    int insert(SubjectJudge subjectJudge);

}

