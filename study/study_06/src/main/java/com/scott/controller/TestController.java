package com.scott.controller;

import com.scott.entity.User;
import com.scott.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CLASSNAME :TestController
 * @Description :数据测试
 * @Author :Mr.薛
 * @Data :2019/3/6 0006  17:16
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class TestController {
    @Autowired
    UserService userService;

    /*查询所有用户信息*/
    @RequestMapping(value = "/selectAllUser",method = RequestMethod.GET)
    public List<User> selectAllUser(){
        List<User> list = userService.selectAllUser();
        if(list.size() > 0){
            return list;
        }else{
            return null;
        }
    }

    /*根据id查询用户信息*/
    @RequestMapping(value = "/selectUserById/{id}",method = RequestMethod.GET)
    public User selectUserById(@PathVariable("id") int id){
        return userService.selectUserById(id);
    }

    /*根据姓名模糊查询*/
    @RequestMapping(value = "/selectLikeName/{name}",method = RequestMethod.GET)
    public List<User> selectLikeName(@PathVariable("name") String name){
        List<User> list = userService.selectLikeName(name);
        if(list.size() > 0){
            return list;
        }else{
            return null;
        }
    }

    /*添加用户信息*/
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUser(@RequestParam("age") int age, @RequestParam("name") String name){
        int m = userService.addUser(age,name);
        if(m > 0){
            return "addUser Success";
        }else{
            return "addUser Failed";
        }
    }

    /*修改用户信息*/
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable("id") int id, @RequestParam("age") int age, @RequestParam("name") String name){
        int m = userService.updateUser(id,age,name);
        if(m > 0){
            return "updateUser Success";
        }else{
            return "updateUser Failed,Please check the id is write";
        }
    }

    /*删除用户信息*/
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") int id){
        int m = userService.deleteUser(id);
        if(m > 0){
            return "deleteUser Success";
        }else{
            return "deleteUser Failed,Please check the id is write";
        }
    }

    /*非事物尝试*/
    @RequestMapping(value = "/sumValueNo",method = RequestMethod.GET)
    public int sumValueNo()throws Exception{
        int num1 = 2;
        int num2 = 2;
        return userService.sumValueNo();
    }

    /*事物尝试*/
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @RequestMapping(value = "/sumValueYes",method = RequestMethod.GET)
    public int sumValueYes()throws Exception{
        int num1 = 2;
        int num2 = 2;
        return userService.sumValueYes();
    }
}
