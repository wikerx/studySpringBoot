package com.scott.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLASSNAME :TestController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  11:03
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class TestController {

    @RequestMapping("/")
    public String Index(){
        System.out.println("Welcome To Our Class - Spring Boot!");
        return "Welcome To Our Class - Spring Boot!";
    }
}
