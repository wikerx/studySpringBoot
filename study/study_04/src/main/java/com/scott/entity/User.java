package com.scott.entity;

import javax.persistence.*;

/**
 * @CLASSNAME :User
 * @Description :创建一个用户对象
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  17:26
 * @Version :V1.0
 * @Status : 编写
 **/
@Entity
@Table(name = "user")
public class User {
//    unique=true是指这个字段的值在这张表里不能重复，所有记录值都要唯一，就像主键那样;
//    nullable=false是这个字段在保存时必需有值，不能还是null值就调用save去保存入库;
    @Id
//设置ID自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, length = 11)
    private int id;

//    创建列：name varchar(20)
    @Column(name = "name", nullable = true, length = 20)
    private String name;
//    创建列：name int(4)
    @Column(name = "age", nullable = true, length = 4)
    private int age;

//只创建表的话不用get set，作为对想使用的话需要，建议加入

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
