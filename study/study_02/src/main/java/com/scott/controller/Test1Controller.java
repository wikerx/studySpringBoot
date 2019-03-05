package com.scott.controller;

import com.scott.entity.Test1Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @CLASSNAME :Test1Controller
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  14:11
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
@EnableConfigurationProperties({Test1Bean.class})
public class Test1Controller {
    @Autowired
    Test1Bean test1Bean;

    @RequestMapping("test1")
    public String Test1(){
        return test1Bean.getCompany();
    }
}
