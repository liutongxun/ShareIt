package com.shareIt.subject.infra.basic.service.impl;


import com.shareIt.subject.infra.basic.entity.SubjectLabel;
import com.shareIt.subject.infra.basic.mapper.SubjectLabelDao;
import com.shareIt.subject.infra.basic.service.SubjectLabelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
     * Insert a new label .
     *
     * @param subjectLabel The SubjectLabel instance to insert
     * @return Number of rows affected
     */
    @Override
    public int insert(SubjectLabel subjectLabel) {

        int insert = this.subjectLabelDao.insert(subjectLabel);

        return insert;
    }

    @Override
    public int update(SubjectLabel subjectLabel) {
        return this.subjectLabelDao.update(subjectLabel);
    }
}

