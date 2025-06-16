package com.shareIt.subject.infra.basic.mapper;


import com.shareIt.subject.infra.basic.entity.SubjectJudge;

import java.util.List;

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

    /**
     * Query a list of SubjectJudge records based on specific conditions.
     * This method retrieves rows that match the given criteria, typically with pagination limits.
     *
     * @param subjectJudge the filter conditions used for querying (e.g., ID, subject ID, answer, etc.)
     * @return a list of SubjectJudge objects that meet the specified conditions
     */
    List<SubjectJudge> queryAllByLimit(SubjectJudge subjectJudge);

}

