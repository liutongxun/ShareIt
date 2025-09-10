package com.liu.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * Entity class representing the assignment of permissions to roles.
 *
 * <p>This class corresponds to the "AuthRolePermission" table and encapsulates
 * the mapping between roles and their associated permissions within the authorization framework.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/10
 */
@Data
public class AuthRolePermission implements Serializable {
    private static final long serialVersionUID = 459343371709166261L;

    /** Unique identifier for this role-permission mapping record */
    private Long id;

    /** Identifier of the role in this mapping */
    private Long roleId;

    /** Identifier of the permission assigned to the role */
    private Long permissionId;

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
//    public Long getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(Long roleId) {
//        this.roleId = roleId;
//    }
//
//    public Long getPermissionId() {
//        return permissionId;
//    }
//
//    public void setPermissionId(Long permissionId) {
//        this.permissionId = permissionId;
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

