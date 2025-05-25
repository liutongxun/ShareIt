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
 * 题目分类(SubjectCategory)表服务实现类
 *
 * @author makejava
 * @since 2025-05-21 14:58:05
 */
@Service("subjectCategoryService")
public class SubjectCategoryServiceImpl implements SubjectCategoryService {
    @Resource
    private SubjectCategoryDao subjectCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SubjectCategory queryById(Integer id) {
        return this.subjectCategoryDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param subjectCategory 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
//    @Override
//    public Page<SubjectCategory> queryByPage(SubjectCategory subjectCategory, PageRequest pageRequest) {
//        long total = this.subjectCategoryDao.count(subjectCategory);
//        return new PageImpl<>(this.subjectCategoryDao.queryAllByLimit(subjectCategory, pageRequest), pageRequest, total);
//    }

    /**
     * 新增数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory insert(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.insert(subjectCategory);
        return subjectCategory;
    }

    /**
     * 修改数据
     *
     * @param subjectCategory 实例对象
     * @return 实例对象
     */
    @Override
    public SubjectCategory update(SubjectCategory subjectCategory) {
        this.subjectCategoryDao.update(subjectCategory);
        return this.queryById(subjectCategory.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.subjectCategoryDao.deleteById(id) > 0;
    }

    @Override
    public List<SubjectCategory> queryPrimaryCategory(SubjectCategory subjectCategory) {
        return subjectCategoryDao.queryPrimaryCategory(subjectCategory);
    }
}
