package com.shareIt.domain.hander.subject;


import com.shareIt.domain.convert.BriefSubjectConverter;
import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.subject.common.enums.IsDeletedFlagEnum;
import com.shareIt.subject.common.enums.SubjectInfoTypeEnum;
import com.shareIt.subject.infra.basic.entity.SubjectBrief;
import com.shareIt.subject.infra.basic.service.SubjectBriefService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Strategy class for Short Answer questions
 *
 * Author: Liu Tongxun
 * Date: 2025/06/03
 */

@Component
public class BriefTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectBriefService subjectBriefService;
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.BRIEF;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        SubjectBrief subjectBrief = BriefSubjectConverter.INSTANCE.convertBoToEntity(subjectInfoBO);
        subjectBrief.setSubjectId(subjectInfoBO.getId().intValue());
        subjectBrief.setIsDeleted( IsDeletedFlagEnum.UN_DELETED.getCode());
        subjectBriefService.insert(subjectBrief);
    }

}
