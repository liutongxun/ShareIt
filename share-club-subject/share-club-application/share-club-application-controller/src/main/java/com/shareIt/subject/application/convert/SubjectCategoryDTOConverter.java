package com.shareIt.subject.application.convert;

import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.subject.application.dto.SubjectCategoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface SubjectCategoryDTOConverter {

    SubjectCategoryDTOConverter INSTANCE = Mappers.getMapper(SubjectCategoryDTOConverter.class);
//
//    List<SubjectCategoryDTO> convertBoToCategoryDTOList(List<SubjectCategoryBO> subjectCategoryDTO);
//
//    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO subjectCategoryDTO);
//
//    SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO subjectCategoryBO);

    // 单对象映射：DTO → BO
    SubjectCategoryBO convertDtoToCategoryBO(SubjectCategoryDTO dto);

    // 单对象映射：BO → DTO
    SubjectCategoryDTO convertBoToCategoryDTO(SubjectCategoryBO bo);

    // 列表映射：DTO 列表 → BO 列表
    List<SubjectCategoryBO> convertDtoListToBoList(List<SubjectCategoryDTO> dtos);

    // 列表映射：BO 列表 → DTO 列表
    List<SubjectCategoryDTO> convertBoListToDtoList(List<SubjectCategoryBO> bos);

}
