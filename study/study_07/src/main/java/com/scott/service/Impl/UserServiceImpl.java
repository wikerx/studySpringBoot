package com.scott.service.Impl;

import com.scott.entity.User;
import com.scott.mapper.IUserDao;
import com.scott.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CLASSNAME :UserServiceImpl
 * @Description :服务实现层
 * @Author :Mr.薛
 * @Data :2019/3/6 0006  16:06
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;

    /*查询所有用户信息*/
    public List<User> selectAllUser(){
        return userDao.selectAllUser();
    }

    /*根据id查询用户信息*/
    public User selectUserById(int id){
        return userDao.selectUserById(id);
    }

    /*根据姓名模糊查询*/
    public List<User> selectLikeName(String name){
        return userDao.selectLikeName(name);
    }

    /*添加用户信息*/
    public int addUser(int age,String name){
        return userDao.addUser(age,name);
    }

    /*修改用户信息*/
    public int updateUser(int id, int age, String name){
        return userDao.updateUser(id,age,name);
    }

    /*删除用户信息*/
    public int deleteUser(int id){
        return userDao.deleteUser(id);
    }
}
