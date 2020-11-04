package com.wsl.dao;
import com.wsl.bean.RolePermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RolePermissionMapper {

    List<RolePermission> getRolePermissionsListByRoleId(Integer roleId);
}
