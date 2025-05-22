package com.shareIt.domain.service.impl;

import com.shareIt.domain.convert.SubjectCategoryConverter;
import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.domain.service.SubjectCategoryDomainService;
import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import com.shareIt.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SubjectCategoryDomainServiceImpl
                                    implements SubjectCategoryDomainService {

    @Resource
    private SubjectCategoryService subjectCategoryService;

    @Override
    public void add(SubjectCategoryBO subjectCategoryBO) {

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl add subjectCategoryBO:{}", subjectCategoryBO);
        }

        SubjectCategory subjectCategory = SubjectCategoryConverter.
                                                        INSTANCE.
                                                        convertBoToCategory(subjectCategoryBO);
        subjectCategoryService.insert(subjectCategory);
    }
}
