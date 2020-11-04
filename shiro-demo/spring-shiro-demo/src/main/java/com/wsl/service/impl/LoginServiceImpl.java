package com.wsl.service.impl;

import com.wsl.bean.*;

import com.wsl.dao.*;
import com.wsl.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.wsl.bean.User;
import com.wsl.bean.Role;
import com.wsl.dao.PermissionMapper;
import com.wsl.dao.RoleMapper;
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    PermissionMapper permissionsMapper;
    @Autowired
    RolePermissionMapper rolePermissionsMapper;

    @Override
    public User getUserByName(String userName) {
      //return getMapByName(userName);
        //查用户
        User user = userMapper.selectByUsername(userName);
        //查角色对象
        Role role = roleMapper.getRoletByUserId(user.getId());
        List<RolePermission> rolePermissionsList = rolePermissionsMapper.getRolePermissionsListByRoleId(role.getId());
        //角色装入属于自己的权限
        role.setRolePermission(rolePermissionsList);
        //用户装入自己的角色
        user.setRole(role);
        return user;
    }

//    /**
//     * 模拟数据库查询
//     *
//     * @param userName 用户名
//     * @return User
//     */
//    private User getMapByName(String userName) {
//        Permissions permissions1 = new Permissions("1", "query");
//        Permissions permissions2 = new Permissions("2", "add");
//        Set<Permissions> permissionsSet = new HashSet<>();
//        permissionsSet.add(permissions1);
//        permissionsSet.add(permissions2);
//        Role role = new Role(1, "admin", permissionsSet);
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);
//        User user = new User("1", "wsl", "123456", roleSet);
//        Map<String, User> map = new HashMap<>();
//        map.put(user.getUserName(), user);
//
//        Set<Permissions> permissionsSet1 = new HashSet<>();
//        permissionsSet1.add(permissions1);
//        Role role1 = new Role(2, "user", permissionsSet1);
//        Set<Role> roleSet1 = new HashSet<>();
//        roleSet1.add(role1);
//        User user1 = new User(2, "zhangsan", "123456", roleSet1);
//        map.put(user1.getUserName(), user1);
//        return map.get(userName);
//    }
}
