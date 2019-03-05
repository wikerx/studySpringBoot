package com.scott.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @CLASSNAME :Test1Bean
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  14:07
 * @Version :V1.0
 * @Status : 编写
 **/
@Configuration
@PropertySource(value = "classpath:application-test1.properties")
@ConfigurationProperties(prefix = "test.pro")
public class Test1Bean {
    private String name;
    private int age;
    private String company;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
