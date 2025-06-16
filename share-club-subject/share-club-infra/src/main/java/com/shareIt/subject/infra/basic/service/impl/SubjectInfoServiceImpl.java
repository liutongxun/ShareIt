package com.shareIt.subject.infra.basic.service.impl;


import com.shareIt.subject.infra.basic.entity.SubjectInfo;
import com.shareIt.subject.infra.basic.mapper.SubjectInfoDao;
import com.shareIt.subject.infra.basic.service.SubjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service Implementation for the Subject Information Table (SubjectInfo)
 *
 * Provides concrete implementations of methods defined in SubjectInfoService,
 * including CRUD operations and custom queries for subject_info data.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
@Service("subjectInfoService")
public class SubjectInfoServiceImpl implements SubjectInfoService {

    @Resource
    private SubjectInfoDao subjectInfoDao;

    @Override
    public SubjectInfo insert(SubjectInfo subjectInfo) {
        this.subjectInfoDao.insert(subjectInfo);
        return subjectInfo;
    }

    @Override
    public int countByCondition(SubjectInfo subjectInfo, Long categoryId, Long labelId) {
        return this.subjectInfoDao.countByCondition(subjectInfo, categoryId, labelId);
    }

    @Override
    public List<SubjectInfo> queryPage(SubjectInfo subjectInfo, Long categoryId, Long labelId, int start, Integer pageSize) {
        return this.subjectInfoDao.queryPage(subjectInfo, categoryId, labelId, start, pageSize);
    }

    @Override
    public SubjectInfo queryById(Long id) {
        return this.subjectInfoDao.queryById(id);
    }
}
