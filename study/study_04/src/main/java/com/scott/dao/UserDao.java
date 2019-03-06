package com.scott.dao;

import com.scott.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @CLASSNAME :UserDao
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  17:31
 * @Version :V1.0
 * @Status : 编写
 **/
//JpaRepository<对象名，表名>
public interface UserDao extends JpaRepository<User,Integer> {

    @Modifying
    @Transactional
    @Query(value = "update User set name = :name where id = :id")
    int modifyUpdateUser(@Param("name") String  name,@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "delete from User where id = :id")
    int deleteByUserId(@Param("id") int id);

//    @Query(value = "select u from User u where u.name LIKE '%?1%' ")
    @Query(value = "select u from User u where u.name LIKE concat('%',:name,'%') ")
    List<User> findByNameLike(@Param("name") String name);



}
