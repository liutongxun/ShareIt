package com.shareIt.domain.hander.subject;


import com.shareIt.domain.convert.RadioSubjectConverter;
import com.shareIt.domain.entity.SubjectAnswerBO;
import com.shareIt.domain.entity.SubjectInfoBO;
import com.shareIt.domain.entity.SubjectOptionBO;
import com.shareIt.subject.common.enums.IsDeletedFlagEnum;
import com.shareIt.subject.common.enums.SubjectInfoTypeEnum;
import com.shareIt.subject.infra.basic.entity.SubjectJudge;
import com.shareIt.subject.infra.basic.entity.SubjectRadio;
import com.shareIt.subject.infra.basic.service.SubjectJudgeService;
import com.shareIt.subject.infra.basic.service.SubjectRadioService;
import org.springframework.stereotype.Component;


import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * Strategy class for Single Choice questions
 *
 * Author: Liu Tongxun
 * Date: 2025/06/03
 */

@Component
public class RadioTypeHandler implements SubjectTypeHandler {

    @Resource
    private SubjectRadioService subjectRadioService;

    @Override
    public SubjectInfoTypeEnum getHandlerType() {
        return SubjectInfoTypeEnum.RADIO;
    }

    @Override
    public void add(SubjectInfoBO subjectInfoBO) {
        // Check if the option list is not null and not empty
        if (subjectInfoBO.getOptionList() != null && !subjectInfoBO.getOptionList().isEmpty()) {
            // Insert single-choice question options
            List<SubjectRadio> subjectRadioList = new LinkedList<>();

            subjectInfoBO.getOptionList().forEach(option -> {
                // Convert the option BO to an  entity object
                SubjectRadio subjectRadio = RadioSubjectConverter.INSTANCE.convertBoToEntity(option);

                // Set the foreign key reference to the subject
                subjectRadio.setSubjectId(subjectInfoBO.getId());

                // Mark as not deleted
                subjectRadio.setIsDeleted(IsDeletedFlagEnum.UN_DELETED.getCode());

                // Add to the list for batch insertion
                subjectRadioList.add(subjectRadio);
            });

            // Perform batch insertion
            subjectRadioService.batchInsert(subjectRadioList);
        }

    }

    @Override
    public SubjectOptionBO query(int subjectId) {
        SubjectRadio subjectRadio = new SubjectRadio();
        subjectRadio.setSubjectId(Long.valueOf(subjectId));
        List<SubjectRadio> result = subjectRadioService.queryByCondition(subjectRadio);
        List<SubjectAnswerBO> subjectAnswerBOList = RadioSubjectConverter.INSTANCE.convertEntityToBoList(result);
        SubjectOptionBO subjectOptionBO = new SubjectOptionBO();
        subjectOptionBO.setOptionList(subjectAnswerBOList);
        return subjectOptionBO;
    }

}
