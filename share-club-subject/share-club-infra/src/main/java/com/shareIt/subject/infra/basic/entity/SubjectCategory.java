package com.shareIt.subject.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-05-21 14:58:01
 */
@ Data
public class SubjectCategory implements Serializable {
    private static final long serialVersionUID = 457608167470818512L;
/**
     * 主键
     */
    private Integer id;
/**
     * 分类名称
     */
    private String categoryName;
/**
     * 分类的类型
     */
    private Integer categoryType;
/**
     * 图标链接
     */
    private String imageUrl;
/**
     * 父级id
     */
    private Integer parentId;
/**
     * 创建人
     */
    private String createdBy;
/**
     * 创建时间
     */
    private Date createdTime;
/**
     * 更新人
     */
    private String updateBy;
/**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 逻辑删除 0未删除 1已删除
     */
    private Integer isDeleted;

}

