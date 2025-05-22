package com.shareIt.domain.convert;

import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE =
                        Mappers.getMapper(SubjectCategoryConverter.class);

    // 将 SubjectCategoryBO 转换为 SubjectCategory
    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);
}
