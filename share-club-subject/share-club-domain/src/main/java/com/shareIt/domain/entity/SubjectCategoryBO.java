package com.shareIt.domain.entity;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 题目分类(SubjectCategory)实体类
 *
 * @author makejava
 * @since 2025-05-21 14:58:01
 */
@Data
public class SubjectCategoryBO implements Serializable {
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


}

