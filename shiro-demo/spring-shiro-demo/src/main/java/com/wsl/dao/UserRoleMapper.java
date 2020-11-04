package com.wsl.dao;
import com.wsl.bean.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper {
    UserRole selectByUserId(Integer userId);
}
