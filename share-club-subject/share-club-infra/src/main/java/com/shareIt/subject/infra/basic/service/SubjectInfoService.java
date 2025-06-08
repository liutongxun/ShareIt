package com.shareIt.subject.infra.basic.service;


import com.shareIt.subject.infra.basic.entity.SubjectInfo;

import java.util.List;

/**
 * Service Interface for the Subject Information Table (SubjectInfo)
 *
 * Defines methods for CRUD operations and custom queries on subject_info data.
 *
 * @author Liu Tongxun
 * @since 2025/06/01
 */
public interface SubjectInfoService {


    /**
     * Insert a new record
     *
     * @param subjectInfo the entity object to be inserted
     * @return the inserted entity object
     */
    SubjectInfo insert(SubjectInfo subjectInfo);


}
