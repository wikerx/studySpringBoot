package com.study.entity;

/**
 * @CLASSNAME :User
 * @Description :用户实体对象
 * @Author :Mr.薛
 * @Data :2019/3/6 0006  15:41
 * @Version :V1.0
 * @Status : 编写
 **/
public class User {
    private int id;
    private int age;
    private String name;

//    get   set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
