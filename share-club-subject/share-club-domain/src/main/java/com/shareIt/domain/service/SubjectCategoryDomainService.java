package com.shareIt.domain.service;

import com.shareIt.domain.entity.SubjectCategoryBO;
import com.shareIt.subject.infra.basic.entity.SubjectCategory;

import java.util.List;

public interface SubjectCategoryDomainService {

    void add(SubjectCategoryBO subjectCategoryBO);

    /**
     * Query Job Categories
     */
    List<SubjectCategoryBO> queryPrimaryCategory();

    List<SubjectCategoryBO> queryCategory(SubjectCategoryBO subjectCategoryBO);

    /**
     * update categories
     */
    Boolean update(SubjectCategoryBO subjectCategoryBO);

    Boolean delete(SubjectCategoryBO subjectCategoryBO);
}
