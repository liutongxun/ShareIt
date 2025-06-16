package com.shareIt.domain.hander.subject;

import com.shareIt.domain.convert.MultipleSubjectConverter;
import com.shareIt.domain.entity.SubjectAnswerBO;
import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.domain.entity.SubjectOptionBO;
import com.shareIt.subject.common.enums.IsDeletedFlagEnum;
import com.shareIt.subject.common.enums.SubjectInfoTypeEnum;
import com.shareIt.subject.infra.basic.entity.SubjectJudge;
import com.shareIt.subject.infra.basic.entity.SubjectMultiple;
import com.shareIt.subject.infra.basic.service.SubjectJudgeService;
import com.shareIt.subject.infra.basic.service.SubjectMultipleService;
import lombok.val;
import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Strategy class for Multiple Choice questions
 *
 * Author: Liu Tongxun
 * Date: 2025/06/03
 */

@Component
public class MultipleTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectMultipleService subjectMultipleService;
    
    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.MULTIPLE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // Inserting multiple choice questions
        if (subjectInfoBO.getOptionList() != null || !subjectInfoBO.getOptionList().isEmpty()){
            LinkedList<SubjectMultiple> multiples = new LinkedList<>();

            subjectInfoBO.getOptionList().forEach(option -> {
                SubjectMultiple subjectMultiple = MultipleSubjectConverter.
                        INSTANCE.convertBoToEntity(option);
                subjectMultiple.setSubjectId(subjectInfoBO.getId());
                subjectMultiple.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
                multiples.add(subjectMultiple);
                }
            );



            subjectMultipleService.batchInsert(multiples);
        }

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectMultiple subjectMultiple = new SubjectMultiple();
        subjectMultiple.setSubjectId(Long.valueOf(subjectId));
        List<SubjectMultiple> result = subjectMultipleService.queryByCondition(subjectMultiple);
        List<SubjectAnswerBO> subjectAnswerBOList = MultipleSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
