package com.scott.controller;
import com.scott.service.RedisService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.scott.entity.User;
import com.scott.service.IUserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.alibaba.fastjson.JSON;
/**
 * @CLASSNAME :TestController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/7 0007  12:13
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class TestController {
    private final static Logger logger = Logger.getLogger(TestController.class);//给类初始化日志对象

    @Autowired
    IUserService userService;
    @Autowired
    private RedisService redisService;

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

    @ResponseBody
    @RequestMapping(value = "/selectUser/{id}",method = RequestMethod.GET)
    public User selectUser(@PathVariable("id") int id){
        User user = null;
        try {
            user = JSON.parseObject(redisService.get("user"), User.class);
            if(user == null){
                user = userService.selectUserById(id);
                redisService.set("user", JSON.toJSONString(user));
                redisService.expire("user",10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("出参user:    userId:"+user.getId()+"    userAge:"+user.getAge()+"    UserName:"+user.getName());//打印info级别的日志
        System.out.println("userId:"+user.getId()+"    userAge:"+user.getAge()+"    UserName:"+user.getName());
        return user;
    }

}