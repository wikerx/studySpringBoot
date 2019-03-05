package com.scott.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLASSNAME :TestController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  12:15
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class TestController {

    @Value("${pro.name}")
    private String name;
    @Value("${pro.age}")
    private int age;
    @Value("${pro.company}")
    private String company;

    @RequestMapping("/")
    public String readYml(){
        String str = "name:"+name+"  age:"+age+"   company:"+company;
        System.out.println(str);
        return "<b style='color:green;'>"+str+"</b>";
    }

}
