package com.wsl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Permission {
    private Integer id;
    private String permission;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }


}
