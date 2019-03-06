package com.study.service;

import com.study.entity.User;

import java.util.List;

/**
 * @CLASSNAME :IUserService
 * @Description :用户接口服务层
 * @Author :Mr.薛
 * @Data :2019/3/6 0006  16:04
 * @Version :V1.0
 * @Status : 编写
 **/
public interface IUserService {
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
