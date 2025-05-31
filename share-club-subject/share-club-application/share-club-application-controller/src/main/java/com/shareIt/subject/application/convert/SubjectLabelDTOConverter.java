package com.shareIt.subject.application.convert;


import com.shareIt.domain.entity.SubjectLabelBO;
import com.shareIt.subject.application.dto.SubjectLabelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Label DTO Conversion
 *
 * Author: Liu Tongxun
 * Date: 2025/05/31
 */

@Mapper
public interface SubjectLabelDTOConverter {

    SubjectLabelDTOConverter INSTANCE = Mappers.getMapper(SubjectLabelDTOConverter.class);

    SubjectLabelBO convertDtoToLabelBO(SubjectLabelDTO subjectLabelDTO);

    List<SubjectLabelDTO> convertBOToLabelDTOList(List<SubjectLabelBO> boList);

}
