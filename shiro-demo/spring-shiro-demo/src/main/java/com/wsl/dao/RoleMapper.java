package com.wsl.dao;
import com.wsl.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface RoleMapper {
    Role getRoletByUserId(Integer userId);
}
