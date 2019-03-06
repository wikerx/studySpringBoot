package com.scott.service;

import com.scott.entity.User;
import org.springframework.data.domain.Page;
import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 * Describ:用户信息
 */
public interface UserService {
    /*查询所有用户*/
    List<User> selectAllUsers();

    /*根据ID查询用户信息*/
    User selectByUid(int id);

    /*添加用户信息*/
    User addUser(User user);

    /*修改用户信息*/
    User updateUser(User user);

    /*删除用户信息*/
    void deleteUser(int id);

    /*jpa分页效果*/
    Page<User> find(Integer page, Integer size);

    /*SQL执行*/
    int modifyUpdateUser(String  name, int id);

    int deleteByUserId(int id);

    List<User>  findByNameLike(String name);

}
