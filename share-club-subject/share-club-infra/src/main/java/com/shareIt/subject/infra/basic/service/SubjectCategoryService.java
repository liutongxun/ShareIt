package com.shareIt.subject.infra.basic.service;

import com.shareIt.subject.infra.basic.entity.SubjectCategory;

import java.util.List;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;


public interface SubjectCategoryService {

    /**
     * Query a single record by ID
     *
     * @param id Primary key
     * @return The instance object
     */
    SubjectCategory queryById(Integer id);



    /**
     * Add a new record
     *
     * @param subjectCategory The instance object
     * @return The instance object
     */
    SubjectCategory insert(SubjectCategory subjectCategory);


    /**
     * Query the primary job categories
     *
     * @param subjectCategory The instance object containing the query conditions
     * @return A list of SubjectCategory objects
     */
    List<SubjectCategory> queryPrimaryCategory(SubjectCategory subjectCategory);

    List<SubjectCategory> queryCategory(SubjectCategory subjectCategory);


    /**
     * Updates a SubjectCategory record.
     *
     * @param subjectCategory the SubjectCategory instance to update
     * @return the updated SubjectCategory instance
     */
    int update(SubjectCategory subjectCategory);


}
