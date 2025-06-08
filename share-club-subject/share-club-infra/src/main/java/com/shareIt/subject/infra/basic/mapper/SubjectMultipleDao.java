package com.shareIt.subject.infra.basic.mapper;

import com.shareIt.subject.infra.basic.entity.SubjectMultiple;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The multiple-choice question information table (SubjectMultiple) database access layer
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectMultipleDao {

    /**
     * Batch insert data (using MyBatis native foreach method)
     *
     * @param entities List<SubjectMultiple> List of instance objects
     * @return Number of affected rows
     */
    int insertBatch(@Param("entities") List<SubjectMultiple> entities);

}
