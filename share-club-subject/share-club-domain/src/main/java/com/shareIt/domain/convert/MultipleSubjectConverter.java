package com.shareIt.domain.convert;

import com.shareIt.domain.entity.SubjectAnswerBO;
import com.shareIt.subject.infra.basic.entity.SubjectMultiple;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface MultipleSubjectConverter {

    MultipleSubjectConverter INSTANCE = Mappers.getMapper(MultipleSubjectConverter.class);
    SubjectMultiple convertBoToEntity(SubjectAnswerBO subjectAnswerBO);

    List<SubjectAnswerBO> convertEntityToBoList(List<SubjectMultiple> result);
}
