package com.shareIt.domain.convert;

import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubjectCategoryConverter {

    SubjectCategoryConverter INSTANCE =
                        Mappers.getMapper(SubjectCategoryConverter.class);

//    // convert SubjectCategoryBO to SubjectCategory
//    SubjectCategory convertBoToCategory(SubjectCategoryBO subjectCategoryBO);
//
//
//    SubjectCategoryBO convertCategoryToBo(SubjectCategory subjectCategory);
//
//
//    List<SubjectCategoryBO> convertCategoryToBo(List<SubjectCategory> categoryList);

    /**
     * BO -> Entity
     * 忽略掉 BO 中不存在的字段
     */
    @Mapping(target = "createdBy"   , ignore = true)
    @Mapping(target = "createdTime" , ignore = true)
    @Mapping(target = "updateBy"    , ignore = true)
    @Mapping(target = "updateTime"  , ignore = true)
    @Mapping(target = "isDeleted"   , ignore = true)
    SubjectCategory convertBoToCategory(SubjectCategoryBO bo);

    /**
     * Entity -> BO
     * 由于 BO 只定义了部分字段，MapStruct 会自动忽略剩下的
     */
    SubjectCategoryBO convertCategoryToBo(SubjectCategory entity);

    /** 列表映射：BO 列表 -> Entity 列表 */
    List<SubjectCategory> convertBoListToCategoryList(List<SubjectCategoryBO> bos);

    /** 列表映射：Entity 列表 -> BO 列表 */
    List<SubjectCategoryBO> convertCategoryListToBoList(List<SubjectCategory> entities);
}
