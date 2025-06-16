package com.shareIt.subject.infra.basic.service.impl;


import com.shareIt.subject.infra.basic.entity.SubjectJudge;
import com.shareIt.subject.infra.basic.mapper.SubjectJudgeDao;
import com.shareIt.subject.infra.basic.service.SubjectJudgeService;
import lombok.val;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Service Implementation for the True/False Question (SubjectJudge) Table
 *
 * Provides concrete implementations of methods defined in SubjectJudgeService,
 * delegating CRUD operations to SubjectJudgeDao.
 *
 * @author Liu Tongxun
 * @since 2023-10-05 21:29:47
 */
@Service("subjectJudgeService")
public class SubjectJudgeServiceImpl implements SubjectJudgeService {

    @Resource
    private SubjectJudgeDao subjectJudgeDao;

    @Override
    public SubjectJudge insert(SubjectJudge subjectJudge) {
        this.subjectJudgeDao.insert(subjectJudge);
        return subjectJudge;
    }

    @Override
    public List<SubjectJudge> queryByCondition(SubjectJudge subjectJudge) {
        return this.subjectJudgeDao.queryAllByLimit(subjectJudge);
    }
}
