package com.shareIt.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.shareIt.domain.convert.SubjectInfoConverter;
import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.domain.entity.SubjectOptionBO;
import com.shareIt.domain.hander.subject.SubjectTypeHandler;
import com.shareIt.domain.hander.subject.SubjectTypeHandlerFactory;
import com.shareIt.domain.service.SubjectInfoDomainService;
import com.shareIt.subject.common.entity.PageResult;
import com.shareIt.subject.common.enums.IsDeletedFlagEnum;
import com.shareIt.subject.infra.basic.entity.SubjectInfo;
import com.shareIt.subject.infra.basic.entity.SubjectLabel;
import com.shareIt.subject.infra.basic.entity.SubjectMapping;
import com.shareIt.subject.infra.basic.service.SubjectInfoService;
import com.shareIt.subject.infra.basic.service.SubjectLabelService;
import com.shareIt.subject.infra.basic.service.SubjectMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SubjectInfoDomainServiceImpl implements SubjectInfoDomainService {

    @Resource
    private SubjectTypeHandlerFactory subjectTypeHandlerFactory;

    @Resource
    private SubjectInfoService subjectInfoService;

    @Resource
    private SubjectLabelService subjectLabelService;

    @Resource
    private SubjectMappingService subjectMappingService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SubjectInfoBO subjectInfoBO) {
        if (log.isInfoEnabled()) {
            log.info("SubjectInfoDomainServiceImpl.add.bo:{}", JSON.toJSONString(subjectInfoBO));
        }
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.
                                                        convertBoToInfo(subjectInfoBO);

        subjectInfo.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        subjectInfoService.insert(subjectInfo);

        SubjectTypeHandler handler = subjectTypeHandlerFactory.
                                                    getHandler(subjectInfo.getSubjectType());

        subjectInfoBO.setId(subjectInfo.getId());

        handler.add(subjectInfoBO);

        List<Integer> categoryIds = subjectInfoBO.getCategoryIds();
        List<Integer> labelIds = subjectInfoBO.getLabelIds();

        LinkedList<SubjectMapping> mappingList = new LinkedList<>();
//        for (int cid = 0; cid < categoryIds.size(); cid++) {
//            for (int lableId =0; lableId <labelIds.size(); lableId++){
//                SubjectMapping mapping = new SubjectMapping();
//                mapping.setSubjectId(subjectInfo.getId());
//                mapping.setCategoryId(Long.valueOf(categoryIds.get(cid)));
//                mapping.setLabelId(Long.valueOf(labelIds.get(lableId)));
//                mapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
//                mappingList.add(mapping);
//            }
//        }
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

    @Override
    public PageResult<SubjectInfoBO> getSubjectPage(SubjectInfoBO subjectInfoBO) {
        PageResult<SubjectInfoBO> pageResult = new PageResult<>();
        pageResult.setPageNo(subjectInfoBO.getPageNo());
        pageResult.setPageSize(subjectInfoBO.getPageSize());
        int start = (subjectInfoBO.getPageNo() - 1) * subjectInfoBO.getPageSize();
        SubjectInfo subjectInfo = SubjectInfoConverter.INSTANCE.convertBoToInfo(subjectInfoBO);
        int count = subjectInfoService.countByCondition(subjectInfo, subjectInfoBO.getCategoryId()
                , subjectInfoBO.getLabelId());
        if (count == 0) {
            return pageResult;
        }
        List<SubjectInfo> subjectInfoList = subjectInfoService.queryPage(subjectInfo, subjectInfoBO.getCategoryId()
                , subjectInfoBO.getLabelId(), start, subjectInfoBO.getPageSize());
        List<SubjectInfoBO> subjectInfoBOS = SubjectInfoConverter.INSTANCE.convertListInfoToBO(subjectInfoList);
        pageResult.setRecords(subjectInfoBOS);
        pageResult.setTotal(count);
        return pageResult;
    }

    @Override
    public SubjectInfoBO querySubjectInfo(SubjectInfoBO subjectInfoBO) {

        SubjectInfo subjectInfo = subjectInfoService.queryById(subjectInfoBO.getId());
        // Check if subjectInfo is null to avoid NullPointerException
        if (subjectInfo == null) {
            // If subjectInfo is null, throw an exception or return a suitable error message
            // In this case, an EntityNotFoundException is thrown with a custom message
            throw new EntityNotFoundException("Subject info not found for id: " + subjectInfoBO.getId());
        }

        SubjectTypeHandler handler = subjectTypeHandlerFactory.getHandler(subjectInfo.getSubjectType());
        SubjectOptionBO optionBO = handler.query(subjectInfo.getId().intValue());

        SubjectInfoBO bo =  SubjectInfoConverter.INSTANCE.convertOptionAndInfoToBo(optionBO, subjectInfo);

        SubjectMapping subjectMapping = new SubjectMapping();
        subjectMapping.setSubjectId(subjectInfo.getId());
        subjectMapping.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

        List<SubjectMapping> mappingList = subjectMappingService.queryLabelId(subjectMapping);
        List<Long> labelIdList = mappingList.stream().
                            map(SubjectMapping::getLabelId).collect(Collectors.toList());

        List<SubjectLabel> labelList = subjectLabelService.batchQueryById(labelIdList);
        List<String> labelNameList = labelList.stream().
                            map(SubjectLabel::getLabelName).collect(Collectors.toList());
        bo.setLabelName(labelNameList);


        return bo ;
    }


}
