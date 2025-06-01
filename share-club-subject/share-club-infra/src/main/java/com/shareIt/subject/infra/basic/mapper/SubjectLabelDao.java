package com.shareIt.subject.infra.basic.mapper;

import com.shareIt.subject.infra.basic.entity.SubjectLabel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Subject Label table (SubjectLabel) Data Access Layer
 *
 * Represents the database access methods for the SubjectLabel table.
 *
 * @author Liu Tongxun
 * @since 2025-05-31
 */
public interface SubjectLabelDao {


    /**
     * Insert a new record
     *
     * @param subjectLabel The SubjectLabel instance to insert
     * @return Number of rows affected
     */
    int insert(SubjectLabel subjectLabel);
    /**
     * Update data
     *
     * @param subjectLabel The SubjectLabel instance
     * @return Number of rows affected
     */
    int update(SubjectLabel subjectLabel);


    /**
     * Query rows by specified conditions
     *
     * @param subjectLabel Query criteria encapsulated as a SubjectLabel object
     * @return List of matching SubjectLabel objects
     */
    List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel);


    /**
     * Batch query records by a list of IDs
     *
     * @param labelIdList List of label IDs
     * @return List of matching SubjectLabel objects
     */
    List<SubjectLabel> batchQueryById(@Param("list") List<Long> labelIdList);
}
