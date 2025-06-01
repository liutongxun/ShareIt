package com.shareIt.subject.infra.basic.service.impl;

import com.shareIt.subject.infra.basic.entity.SubjectCategory;
import com.shareIt.subject.infra.basic.mapper.SubjectCategoryDao;
import com.shareIt.subject.infra.basic.service.SubjectCategoryService;
import org.springframework.stereotype.Service;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * SubjectCategory Table Service Implementation Class
 *
 * @author Liu Tongxun
 * @since 2025-05-21 14:58:05
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * Query a single record by ID
     *
     * @param id Primary key
     * @return The instance object
     */
    @Override
    public SubjectCategory queryById(Long id) {
        return this.subjectCategoryDao.queryById(id);
    }




    /**
     * Add a new record
     *
     * @param subjectCategory The instance object
     * @return The instance object
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }



    /**
     * Query the primary job categories
     *
     * @param subjectCategory The instance object containing the query conditions
     * @return A list of SubjectCategory objects
     */
    @Override
    public List<SubjectCategory> queryPrimaryCategory(SubjectCategory subjectCategory) {
        return subjectCategoryDao.queryPrimaryCategory(subjectCategory);
    }

    @Override
    public List<SubjectCategory> queryCategory(SubjectCategory subjectCategory) {
        return subjectCategoryDao.queryPrimaryCategory(subjectCategory);
    }

    @Override
    public int update(SubjectCategory subjectCategory) {
        return this.subjectCategoryDao.update(subjectCategory);
    }
}
