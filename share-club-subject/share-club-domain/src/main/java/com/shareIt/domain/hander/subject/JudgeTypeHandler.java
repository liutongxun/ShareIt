package com.shareIt.domain.hander.subject;


import com.shareIt.domain.convert.JudgeSubjectConverter;
import com.shareIt.domain.entity.SubjectAnswerBO;
import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.domain.entity.SubjectOptionBO;
import com.shareIt.subject.common.enums.IsDeletedFlagEnum;
import com.shareIt.subject.common.enums.SubjectInfoTypeEnum;
import com.shareIt.subject.infra.basic.entity.SubjectJudge;
import com.shareIt.subject.infra.basic.service.SubjectJudgeService;
import lombok.val;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Strategy class for True/False questions
 *
 * Author: Liu Tongxun
 * Date: 2025/06/03
 */

@Component
public class JudgeTypeHandler implements SubjectTypeHandler{

    @Resource
    private SubjectJudgeService subjectJudgeService;
    
    @Override
    public SubjectInfoTypeEnum  getHandlerType() {
        return SubjectInfoTypeEnum.JUDGE;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // Insertion of True/False Question
        if (subjectInfoBO.getOptionList() != null || !subjectInfoBO.getOptionList().isEmpty()){
            SubjectJudge subjectJudge = new SubjectJudge();
            SubjectAnswerBO subjectAnswerBO = subjectInfoBO.getOptionList().get(0);
            subjectJudge.setSubjectId(subjectInfoBO.getId());
            subjectJudge.setIsCorrect(subjectAnswerBO.getIsCorrect());
            subjectJudge.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());
            subjectJudgeService.insert(subjectJudge);
        }

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectJudge subjectJudge = new SubjectJudge();
        subjectJudge.setSubjectId(Long.valueOf(subjectId));
        List<SubjectJudge> result = subjectJudgeService.queryByCondition(subjectJudge);
        List<SubjectAnswerBO> subjectAnswerBOList = JudgeSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
