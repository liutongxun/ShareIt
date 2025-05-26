package com.shareIt.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.shareIt.domain.convert.SubjectCategoryConverter;
import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.domain.service.SubjectCategoryDomainService;
import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import com.shareIt.subject.infra.basic.service.SubjectCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<SubjectCategoryBO> queryPrimaryCategory() {
        SubjectCategory subjectCategory = new  SubjectCategory();
        subjectCategory.setParentId(0);
        List<SubjectCategory> categoryList = subjectCategoryService.queryPrimaryCategory(subjectCategory);
        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryDomainServiceImpl queryPrimaryCategory categoryList:{}", categoryList);
        }
        Preconditions.checkNotNull(categoryList,"categoryList is empty");


        List<SubjectCategoryBO> subjectCategoryBOS = SubjectCategoryConverter
                                                                    .INSTANCE
                                                                    .convertCategoryListToBoList(categoryList);

        return subjectCategoryBOS;
    }

    @Override
    public List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO) {

        SubjectCategory subjectCategory = SubjectCategoryConverter.INSTANCE
                .convertBoToCategory(subjectCategoryBO);

        System.out.println("subjectCategory            "+JSON.toJSONString(subjectCategory));
        List<SubjectCategory> subjectCategoryList = subjectCategoryService.queryCategory(subjectCategory);

        List<SubjectCategoryBO> boList = SubjectCategoryConverter.INSTANCE
                .convertCategoryListToBoList(subjectCategoryList);

        if (log.isInfoEnabled()) {
            log.info("SubjectCategoryController.queryPrimaryCategory.boList:{}",
                    JSON.toJSONString(boList));
        }

        return boList;
    }


}
