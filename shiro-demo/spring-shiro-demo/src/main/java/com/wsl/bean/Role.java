package com.wsl.bean;

import lombok.Data;

import java.util.List;

@Data

public class Role {

    private Integer id;
    private String roleName;
    private List<RolePermission> rolePermission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<RolePermission> getRolePermission() {
        return rolePermission;
    }

    public void setRolePermission(List<RolePermission> rolePermission) {
        this.rolePermission = rolePermission;
    }
}
