package com.shareIt.subject.infra.basic.service.impl;


import com.shareIt.subject.infra.basic.entity.SubjectMapping;
import com.shareIt.subject.infra.basic.mapper.SubjectMappingDao;
import com.shareIt.subject.infra.basic.service.SubjectMappingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * Service implementation for the Subject-Category-Label Mapping table (SubjectMapping)
 *
 * Provides methods to perform CRUD operations and batch inserts on the SubjectMapping entity.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
@Service("subjectMappingService")
public class SubjectMappingServiceImpl implements SubjectMappingService {

    @Resource
    private SubjectMappingDao subjectMappingDao;

     /**
     * Query distinct label IDs based on given criteria
     *
     * @param subjectMapping Query criteria
     * @return List of SubjectMapping instances with distinct labelId values
     */
    @Override
    public List<SubjectMapping> queryLabelId(SubjectMapping subjectMapping) {
        return this.subjectMappingDao.queryDistinctLabelId(subjectMapping);
    }

}
