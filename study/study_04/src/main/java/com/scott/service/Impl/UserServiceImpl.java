package com.scott.service.Impl;

import com.scott.dao.UserDao;
import com.scott.entity.User;
import com.scott.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CLASSNAME :UserServiceImpl
 * @Description :用户信息操作实现
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  17:41
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    /*查询所有用户*/
    public List<User> selectAllUsers(){
        return userDao.findAll();
    }

    /*根据ID查询用户信息*/
    public User selectByUid(int id){
//        return userDao.getOne(id);//存在即返回，不存在抛出异常
//        return userDao.findOne(id);//2.0之前的版本 存在返回，不存在返回null
        return userDao.findById(id).get();
    }

    /*添加用户信息*/
    public User addUser(User user){
        return userDao.save(user);//保存 返回当前未执行数据库的数据
    }

    /*修改用户信息*/
    public User updateUser(User user){
        return userDao.saveAndFlush(user);//保存之后刷新，返回当前修改的数据对象
    }

    /*删除用户信息*/
    public void deleteUser(int id){
        userDao.deleteById(id);
//        userDao.delete(user);//根据对象删除
    }

    public Page<User> find(Integer page, Integer size) {
        if (null == page) {
            page = 0;
        }
        if (size==0) {
            size = 10;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "id");
        Page<User> users = userDao.findAll(pageable);
        return users;
    }

    @Transactional
    public int modifyUpdateUser(String name, int id){
        return userDao.modifyUpdateUser(name,id);
    }

    public int deleteByUserId(int id){
        return userDao.deleteByUserId(id);
    }

    public List<User>  findByNameLike(String name){
        return userDao.findByNameLike(name);
    }

}
