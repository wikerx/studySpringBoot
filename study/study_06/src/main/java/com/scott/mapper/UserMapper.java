package com.scott.mapper;

import com.scott.entity.User;

import java.util.List;

/*generator自动生成*/
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /*查询所有用户信息*/
    List<User> selectAllUser();

    /*根据姓名模糊查询*/
    List<User> selectLikeName(String name);
}