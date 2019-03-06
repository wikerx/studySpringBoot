package com.study.mapper;

import com.study.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2019/3/6 0006.
 * Describ:数据库交互层 - 注解实现，直接写入SQL语句
 */
@Mapper
public interface IUserDao {
    /*查询所有用户信息*/
    @Select("select * from user")
    List<User> selectAllUser();

    /*根据id查询用户信息*/
    @Select("select * from user where id = #{id}")
    User selectUserById(@Param("id") int id);

    /*根据姓名模糊查询*/
    @Select("select * from user where name LIKE concat('%',#{name},'%') ")
    List<User> selectLikeName(@Param("name") String name);

    /*添加用户信息*/
    @Insert("insert into user(age,name) values(#{age},#{name})")
    int addUser(@Param("age") int age,@Param("name") String name);

    /*修改用户信息*/
    @Update("update user set age = #{age},name = #{name} where id = #{id}")
    int updateUser(@Param("id") int id, @Param("age") int age, @Param("name") String name);

    /*删除用户信息*/
    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);

}
