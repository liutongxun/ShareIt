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

}
