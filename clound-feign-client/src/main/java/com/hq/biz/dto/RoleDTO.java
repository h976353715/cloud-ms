package com.hq.biz.dto;


import com.hq.biz.base.BaseEntity;

/**
 * @author hq
 * @Package com.hq.biz.dto
 * @Description: 角色类
 * @date 2018/4/12 13:58
 */
public class RoleDTO extends BaseEntity {

    private String id;

    /**
     * 角色名
     */
    private String roleName;
    /**
     * 角色code
     */
    private String roleCode;
    /**
     * 是否可用 1：可用 0:禁用
     */
    private Integer useFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Integer useFlag) {
        this.useFlag = useFlag;
    }

}
