package com.shareIt.subject.infra.basic.service.impl;

import com.shareIt.subject.infra.basic.entity.SubjectMultiple;
import com.shareIt.subject.infra.basic.mapper.SubjectMultipleDao;
import com.shareIt.subject.infra.basic.service.SubjectMultipleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Service Implementation Class for the Multiple Choice Question Table (SubjectMultiple)
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
@Service("subjectMultipleService")
public class SubjectMultipleServiceImpl implements SubjectMultipleService {

    @Resource
    private SubjectMultipleDao subjectMultipleDao;

    @Override
    public void batchInsert(List<SubjectMultiple> subjectMultipleList) {
        this.subjectMultipleDao.insertBatch(subjectMultipleList);

    }

    @Override
    public List<SubjectMultiple> queryByCondition(SubjectMultiple subjectMultiple) {
        return this.subjectMultipleDao.queryAllByLimit(subjectMultiple);
    }
}
