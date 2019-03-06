package com.scott.service;

import com.scott.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2019/3/6 0006.
 * Descirb:用户信息服务层
 */
public interface UserService {
    /*查询所有用户信息*/
    List<User> selectAllUser();

    /*根据id查询用户信息*/
    User selectUserById(int id);

    /*根据姓名模糊查询*/
    List<User> selectLikeName(String name);

    /*添加用户信息*/
    int addUser(int age,String name);

    /*修改用户信息*/
    int updateUser(int id, int age, String name);

    /*删除用户信息*/
    int deleteUser(int id);
}
