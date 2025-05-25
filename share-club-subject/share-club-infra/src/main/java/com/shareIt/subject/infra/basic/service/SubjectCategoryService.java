package com.shareIt.subject.infra.basic.service;

import com.shareIt.subject.infra.basic.entity.SubjectCategory;

import java.util.List;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;

/**
 * 题目分类(SubjectCategory)表服务接口
 *
 * @author makejava
 * @since 2025-05-21 14:58:05
 */
public interface SubjectCategoryService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SubjectCategory queryById(Integer id);

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    Page<SubjectCategory> queryByPage(SubjectCategory subjectCategory, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory insert(SubjectCategory subjectCategory);

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    SubjectCategory update(SubjectCategory subjectCategory);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<SubjectCategory> queryPrimaryCategory(SubjectCategory subjectCategory);
}
