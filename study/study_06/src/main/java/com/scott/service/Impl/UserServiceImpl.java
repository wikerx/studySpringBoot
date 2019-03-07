package com.scott.service.Impl;

import com.scott.entity.User;
import com.scott.mapper.UserMapper;
import com.scott.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

/**
 * @CLASSNAME :UserServiceImpl
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/6 0006  17:07
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    /*查询所有用户信息*/
    public List<User> selectAllUser(){
        return userMapper.selectAllUser();
    }

    /*根据id查询用户信息*/
    public User selectUserById(int id){
        return userMapper.selectByPrimaryKey(id);
    }

    /*根据姓名模糊查询*/
    public List<User> selectLikeName(String name){
        return userMapper.selectLikeName(name);
    }

    /*添加用户信息*/
    public int addUser(int age,String name){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return userMapper.insertSelective(user);
    }

    /*修改用户信息*/
    public int updateUser(int id, int age, String name){
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setId(id);
        return userMapper.updateByPrimaryKeySelective(user);
    }

    /*删除用户信息*/
    public int deleteUser(int id){
        return userMapper.deleteByPrimaryKey(id);
    }


    /*非事物尝试*/
    public int sumValueNo()throws RuntimeException{
        method1();
        User user = new User();
        user.setName("scott2");
        user.setId(33);
        userMapper.updateByPrimaryKeySelective(user);
        int i=1/0;
        return 0;
    }

    /*事物尝试*/
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public int sumValueYes()throws RuntimeException{
        method1();
        User user = new User();
        user.setName("scott2");
        user.setId(33);
        userMapper.updateByPrimaryKeySelective(user);
        int i=1/0;
        return 1;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void method1() {
        User user = new User();
        user.setName("scott1");
        user.setId(33);
        userMapper.updateByPrimaryKeySelective(user);
    }


}
