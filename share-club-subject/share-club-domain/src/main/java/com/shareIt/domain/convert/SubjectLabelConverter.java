package com.shareIt.domain.convert;

import com.shareIt.domain.entity.SubjectLabelBO;
import com.shareIt.subject.infra.basic.entity.SubjectLabel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.security.auth.Subject;
import java.util.List;

@Mapper
public interface SubjectLabelConverter {

    SubjectLabelConverter INSTANCE =  Mappers.getMapper(SubjectLabelConverter.class);
    SubjectLabel convertBoToLabel(SubjectLabelBO subjectLabelBO);

    List<SubjectLabelBO> convertLabelToBoList(List<SubjectLabel> labelList);
}
