package com.liu.auth.infra.basic.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * Entity class representing an authorization permission.
 *
 * <p>This class corresponds to the "AuthPermission" table and encapsulates
 * the properties and behaviors of a single permission within the system's
 * authorization framework.</p>
 *
 * @author Liu tongxun
 * @since 2025/09/10
  */
@Data
public class AuthPermission implements Serializable {
    private static final long serialVersionUID = -56518358607843924L;

    /** Unique identifier for this permission record */
    private Long id;

    /** Human-readable name of the permission */
    private String name;

    /** Identifier of the parent permission (for hierarchical menus) */
    private Long parentId;

    /** Permission type (e.g., 0 = menu, 1 = action/button) */
    private Integer type;

    /** URL path associated with this permission when used as a menu */
    private String menuUrl;

    /** Status flag (e.g., 0 = inactive, 1 = active) */
    private Integer status;

    /** Visibility flag (e.g., 0 = hidden, 1 = visible in UI) */
    private Integer show;

    /** Icon CSS class or resource name for UI representation */
    private String icon;

    /** Unique key string used for permission checks in code */
    private String permissionKey;

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
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Long getParentId() {
//        return parentId;
//    }
//
//    public void setParentId(Long parentId) {
//        this.parentId = parentId;
//    }
//
//    public Integer getType() {
//        return type;
//    }
//
//    public void setType(Integer type) {
//        this.type = type;
//    }
//
//    public String getMenuUrl() {
//        return menuUrl;
//    }
//
//    public void setMenuUrl(String menuUrl) {
//        this.menuUrl = menuUrl;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }
//
//    public Integer getShow() {
//        return show;
//    }
//
//    public void setShow(Integer show) {
//        this.show = show;
//    }
//
//    public String getIcon() {
//        return icon;
//    }
//
//    public void setIcon(String icon) {
//        this.icon = icon;
//    }
//
//    public String getPermissionKey() {
//        return permissionKey;
//    }
//
//    public void setPermissionKey(String permissionKey) {
//        this.permissionKey = permissionKey;
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

