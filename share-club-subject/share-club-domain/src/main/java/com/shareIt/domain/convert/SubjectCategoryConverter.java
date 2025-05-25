package com.shareIt.domain.convert;

import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE =
                        Mappers.getMapper(SubjectCategoryConverter.class);

    // convert SubjectCategoryBO to SubjectCategory
    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);


//    SubjectCategoryBO convertCategoryToBo(SubjectCategory subjectCategory);


    List<SubjectCategoryBO> convertCategoryToBo(List<SubjectCategory> categoryList);


}
