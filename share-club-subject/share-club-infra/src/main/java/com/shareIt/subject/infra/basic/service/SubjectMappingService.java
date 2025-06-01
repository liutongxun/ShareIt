package com.shareIt.subject.infra.basic.service;


import com.shareIt.subject.infra.basic.entity.SubjectMapping;
import com.shareIt.subject.infra.basic.mapper.SubjectMappingDao;

import javax.annotation.Resource;
import java.util.List;

import java.util.List;

/**
 * Service Interface for the Subject-Category-Label Mapping table (SubjectMapping)
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectMappingService {




    /**
     * Query label IDs based on given criteria
     *
     * @param subjectMapping Query criteria
     * @return List of SubjectMapping instances matching the criteria
     */
    List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping);


}
