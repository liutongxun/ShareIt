package com.liu.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * Entity class representing the association between a user and a role.
 *
 * <p>This class corresponds to the "AuthUserRole" table and encapsulates
 * the mapping of users to their assigned roles within the authorization framework.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/09
 */
@Data
public class AuthUserRole implements Serializable {
    private static final long serialVersionUID = -34579360091831908L;

    /** Unique identifier for this user-role mapping record */
    private Long id;

    /** Identifier of the user associated with this role */
    private Long userId;

    /** Identifier of the role assigned to the user */
    private Long roleId;

    /** Username of the user who created this record */
    private String createdBy;

    /** Timestamp when this record was first created */
    private Date createdTime;

    /** Username of the user who last updated this record */
    private String updateBy;

    /** Timestamp when this record was last updated */
    private Date updateTime;

    /** Logical deletion flag (e.g., 0 = not deleted, 1 = deleted) */
    private Integer isDeleted;



//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getUserId() {
//        return userId;
//    }
//
//    public void setUserId(Long userId) {
//        this.userId = userId;
//    }
//
//    public Long getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Long roleId) {
//        this.roleId = roleId;
//    }
//
//    public String getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(String createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public Date getCreatedTime() {
//        return createdTime;
//    }
//
//    public void setCreatedTime(Date createdTime) {
//        this.createdTime = createdTime;
//    }
//
//    public String getUpdateBy() {
//        return updateBy;
//    }
//
//    public void setUpdateBy(String updateBy) {
//        this.updateBy = updateBy;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public Integer getIsDeleted() {
//        return isDeleted;
//    }
//
//    public void setIsDeleted(Integer isDeleted) {
//        this.isDeleted = isDeleted;
//    }

}

