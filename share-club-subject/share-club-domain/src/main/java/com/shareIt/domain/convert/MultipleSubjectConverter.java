package com.shareIt.domain.convert;

import com.shareIt.domain.entity.SubjectAnswerBO;
import com.shareIt.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.factory.Mappers;

public interface MultipleSubjectConverter {

    MultipleSubjectConverter INSTANCE = Mappers.getMapper(MultipleSubjectConverter.class);
    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

}
