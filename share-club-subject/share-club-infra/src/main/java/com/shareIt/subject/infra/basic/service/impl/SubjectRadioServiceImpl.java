package com.shareIt.subject.infra.basic.service.impl;


import com.shareIt.subject.infra.basic.entity.SubjectRadio;
import com.shareIt.subject.infra.basic.mapper.SubjectRadioDao;
import com.shareIt.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Service Implementation Class for the Single Choice Question Table (SubjectRadio)
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */

@Service("subjectRadioService")
public class SubjectRadioServiceImpl implements SubjectRadioService {

    @Resource
    private SubjectRadioDao subjectRadioDao;

    @Override
    public void batchInsert(List<SubjectRadio> subjectRadioList) {
        this.subjectRadioDao.insertBatch(subjectRadioList);

    }
}
