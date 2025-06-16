package com.shareIt.subject.infra.basic.mapper;


import com.shareIt.subject.infra.basic.entity.SubjectRadio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Data Access Layer for the Single Choice Question Table (SubjectRadio)
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectRadioDao {


    /**
     * Batch insert records using MyBatis native foreach method
     *
     * @param entities List of SubjectRadio entity objects to be inserted
     * @return number of rows affected
     */
    int insertBatch(@Param("entities") List<SubjectRadio> entities);

    /**
     * Query a list of SubjectRadio records based on specified conditions.
     * This method retrieves rows that match the given filter criteria, typically used for paginated or conditional queries.
     *
     * @param subjectRadio the filter criteria used to query SubjectRadio records (e.g., subject ID, answer content, etc.)
     * @return a list of SubjectRadio objects that satisfy the given conditions
     */
    List<SubjectRadio> queryAllByLimit(SubjectRadio subjectRadio);
}

