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

}

