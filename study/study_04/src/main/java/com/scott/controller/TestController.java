package com.scott.controller;

import com.scott.entity.User;
import com.scott.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CLASSNAME :TestController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/6 0006  9:43
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class TestController {

    @Autowired
    UserService userService;

    /*查询所有用户信息*/
    @RequestMapping(value = "/selectAllUsers",method = RequestMethod.GET)
    public List<User> selectAllUsers(){
        List<User> list = userService.selectAllUsers();
        if(list.size() > 0){
            return list;
        }else{
            return null;
        }
    }

    /*根据id查询用户信息*/
    @RequestMapping(value = "/selectByUid/{id}",method = RequestMethod.GET)
    public User selectByUid(@PathVariable("id") int id){
        return userService.selectByUid(id);
    }

    /*添加用户数据信息*/
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public User addUser(@RequestParam("name")String name,
                        @RequestParam("age")int age){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user = userService.addUser(user);
        return user;
    }

    /*修改用户数据信息*/
    @RequestMapping(value = "/updateUser/{id}",method = RequestMethod.PUT)
    public User updateUser(@PathVariable("id")int id,
                           @RequestParam("name")String name,
                           @RequestParam("age")int age){
        User user = new User();
        user.setAge(age);
        user.setName(name);
        user.setId(id);
        user = userService.updateUser(user);
        return user;
    }

    /*删除用户数据信息*/
    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id")int id){
        userService.deleteUser(id);
        return "delete 已执行，刷新查看结果！";
    }

    /*分页查询用户信息*/
    @RequestMapping(value = "/pageUsers",method = RequestMethod.GET)
    public Page<User> pageUsers(Integer pageOffset, Integer pageSize){
        Page<User> users = userService.find(pageOffset, pageSize);
        return users;
    }

    /*SQL根据id修改用户名称*/
    @RequestMapping(value = "/modifyUpdateUser/{id}",method = RequestMethod.PUT)
    public String modifyUpdateUser(@PathVariable("id")int id,
                                   @RequestParam("name")String name){
        int m = userService.modifyUpdateUser(name,id);
        if(m > 0) {
            return "modifyUpdateUser is OK!";
        }else{
            return "modifyUpdateUser is FAIL,maybe your id is wrong number!";
        }
    }

    /*SQL根据id删除用户信息*/
    @RequestMapping(value = "/deleteByUserId/{id}",method = RequestMethod.DELETE)
    public String deleteByUserId(@PathVariable("id")int id){
        int m = userService.deleteByUserId(id);
        if(m > 0) {
            return "deleteByUserId is OK!";
        }else{
            return "deleteByUserId is FAIL,maybe your id is wrong number!";
        }
    }

    /*SQL根据姓名模糊查询*/
    @RequestMapping(value = "/findByNameLike",method = RequestMethod.GET)
    public List<User> findByNameLike(@RequestParam("name")String name){
        List<User> list = userService.findByNameLike(name);
        if(list.size() > 0){
            return list;
        }else{
            return null;
        }
    }

}
