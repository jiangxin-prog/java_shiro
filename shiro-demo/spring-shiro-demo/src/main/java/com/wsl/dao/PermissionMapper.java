package com.wsl.dao;
import com.wsl.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PermissionMapper {
    List selectListByPermissionsIds(String permissionsIdStr);
}
