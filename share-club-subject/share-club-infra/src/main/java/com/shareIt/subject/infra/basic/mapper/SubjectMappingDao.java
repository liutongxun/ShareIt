package com.shareIt.subject.infra.basic.mapper;

import com.shareIt.subject.infra.basic.entity.SubjectMapping;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Data Access Layer for the Subject-Category-Label Mapping table (SubjectMapping)
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectMappingDao {

    /**
     * Query distinct label IDs based on given criteria
     *
     * @param subjectMapping Query criteria
     * @return List of SubjectMapping instances with distinct labelId values
     */
    List<SubjectMapping> queryDistinctLabelId(SubjectMapping subjectMapping);

    /**
     * Batch insert data using MyBatis native foreach method
     *
     * @param entities List of SubjectMapping entity objects to be inserted
     * @return number of rows affected
     */
    int insertBatch(@Param("entities") List<SubjectMapping> entities);


}
