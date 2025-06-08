package com.shareIt.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.shareIt.domain.convert.SubjectInfoConverter;
import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.domain.hander.subject.SubjectTypeHandler;
import com.shareIt.domain.hander.subject.SubjectTypeHandlerFactory;
import com.shareIt.domain.service.SubjectInfoDomainService;
import com.shareIt.subject.common.enums.IsDeletedFlagEnum;
import com.shareIt.subject.infra.basic.entity.SubjectInfo;
import com.shareIt.subject.infra.basic.entity.SubjectMapping;
import com.shareIt.subject.infra.basic.service.SubjectInfoService;
import com.shareIt.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.
                                                        convertBoToInfo(subjectInfoBO);
        subjectInfoService.insert(subjectInfo);

        SubjectTypeHandler handler = subjectTypeHandlerFactory.
                                                    getHandler(subjectInfo.getSubjectType());

        handler.add(subjectInfoBO);

        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();
        List<SubjectMapping> mappingList = new LinkedList<>();
        categoryIds.forEach(categoryId -> {
            labelIds.forEach(labelId -> {
                SubjectMapping subjectMapping = new SubjectMapping();
                subjectMapping.setSubjectId(subjectInfo.getId());
                subjectMapping.setCategoryId(Long.valueOf(categoryId));
                subjectMapping.setLabelId(Long.valueOf(labelId));
                subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                mappingList.add(subjectMapping);
            });
        });
        subjectMappingService.batchInsert(mappingList);

    }
}
