package com.shareIt.subject.infra.basic.service.impl;


import com.shareIt.subject.infra.basic.entity.SubjectBrief;
import com.shareIt.subject.infra.basic.mapper.SubjectBriefDao;
import com.shareIt.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
/**
 * Service Implementation for the Essay Question (SubjectBrief) Table
 *
 * Provides methods for CRUD operations on subject_brief data.
 *
 * Author: Liu Tongxun
 * Since: 2025/06/01
 */
@Service("subjectBriefService")
public class SubjectBriefServiceImpl implements SubjectBriefService {

    @Resource
    private SubjectBriefDao subjectBriefDao;

    @Override
    public SubjectBrief insert(SubjectBrief subjectBrief) {
        this.subjectBriefDao.insert(subjectBrief);
        return subjectBrief;
    }

    @Override
    public SubjectBrief queryByCondition(SubjectBrief subjectBrief) {
        return this.subjectBriefDao.queryAllByLimit(subjectBrief);
    }
}
