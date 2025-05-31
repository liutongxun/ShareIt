package com.shareIt.subject.infra.basic.service.impl;


import com.shareIt.subject.infra.basic.entity.SubjectLabel;
import com.shareIt.subject.infra.basic.mapper.SubjectLabelDao;
import com.shareIt.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Subject Label Service Implementation
 *
 * Provides the service layer implementation for the SubjectLabel entity.
 *
 * @author Liu Tongxun
 * @since 2025-05-31
 */
@Service("subjectLabelService")
public class SubjectLabelServiceImpl implements SubjectLabelService {

    @Resource
    private SubjectLabelDao subjectLabelDao;

    /**
     * Retrieve a single record by its ID.
     *
     * @param id Primary key
     * @return The SubjectLabel entity object
     */
    @Override
    public SubjectLabel queryById(Long id) {
        return this.subjectLabelDao.queryById(id);
    }

    /**
     * Insert a new record.
     *
     * @param subjectLabel The SubjectLabel instance to insert
     * @return Number of rows affected
     */
    @Override
    public int insert(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.insert(subjectLabel);
    }

    /**
     * Update an existing record.
     *
     * @param subjectLabel The SubjectLabel instance containing updated data
     * @return Number of rows affected
     */
    @Override
    public int update(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.update(subjectLabel);
    }

    /**
     * Delete a record by its primary key.
     *
     * @param id Primary key of the record to delete
     * @return True if deletion was successful, false otherwise
     */
    @Override
    public boolean deleteById(Long id) {
        return this.subjectLabelDao.deleteById(id) > 0;
    }

    /**
     * Retrieve multiple records by a list of IDs.
     *
     * @param labelIdList List of SubjectLabel IDs
     * @return List of matching SubjectLabel objects
     */
    @Override
    public List<SubjectLabel> batchQueryById(List<Long> labelIdList) {
        return this.subjectLabelDao.batchQueryById(labelIdList);
    }

    /**
     * Query records based on specified conditions.
     *
     * @param subjectLabel Query criteria encapsulated as a SubjectLabel object
     * @return List of matching SubjectLabel objects
     */
    @Override
    public List<SubjectLabel> queryByCondition(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.queryByCondition(subjectLabel);
    }
}

