package com.shareIt.subject.infra.basic.mapper;

import com.shareIt.subject.infra.basic.entity.SubjectBrief;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Data Access Layer for the Essay Question (SubjectBrief) Table
 *
 * Provides methods for CRUD operations on the subject_brief table.
 *
 * Author: makejava
 * Since: 2023-10-05
 */
public interface SubjectBriefDao {

    /**
     * Add new data
     *
     * @param subjectBrief Instance object
     * @return Number of affected rows
     */
    int insert(SubjectBrief subjectBrief);


    /**
     * Query a list of subject briefs with pagination constraints.
     * This method retrieves a limited number of SubjectBrief records based on the given conditions,
     * such as offset and limit for paginated results.
     *
     * @param subjectBrief an object containing filter criteria and pagination parameters (e.g., page number, page size)
     * @return a list of SubjectBrief objects that meet the specified conditions and limits
     */
    SubjectBrief queryAllByLimit(SubjectBrief subjectBrief);

}
