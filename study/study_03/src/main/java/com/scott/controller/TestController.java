package com.scott.controller;

import com.scott.entity.Order;
import com.scott.service.IOrderService;
import com.scott.utils.GetOrderNo;
import com.scott.utils.Ognl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @CLASSNAME :TestController
 * @Description :DOTO
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  15:44
 * @Version :V1.0
 * @Status : 编写
 **/
@RestController
public class TestController {
    @Autowired
    IOrderService orderService;

    /*查询订单信息*/
    @RequestMapping(value = "/selectAllOrders",method = RequestMethod.GET)
    public List<Order> selectAllOrders(){
        return orderService.selectAllOrders();
    }

    @RequestMapping(value = "/selectById/{id}",method = RequestMethod.GET)
    /*查询订单信息- selectById*/
    public Order selectById(@PathVariable(value = "id")Long id){
        return orderService.selectById(id);
    }

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    /*添加订单信息*/
    public String addOrder(){
        Order order = new Order();
        int num = (int)(Math.random()*1000+1);
        order.setOrderName("测试产品"+num);
        order.setOrderNo(GetOrderNo.ReturnOrderNo());
        order.setRemark("测试产品测试数据"+num);
        int m = orderService.addOrder(order);
        if(m > 0){
            return "add Order Success";
        }else{
            return "add Order Fail";
        }
    }

    @RequestMapping(value = "/updateOrdedr/{id}",method = RequestMethod.PUT)
    /*修改订单信息*/
    public String updateOrdedr(@RequestParam(value = "name",required = true)String name,
                               @RequestParam(value = "no",required = true)String no,
                               @RequestParam(value = "remark",required = true)String remark,
                               @PathVariable(value = "id")Long id){
        Order order = new Order();
        order.setOrderName(name);
        order.setOrderNo(no);
        order.setRemark(remark);
        order.setId(id);
        int m = 0;
        if(Ognl.isEmpty(id)){
            return "id can't be Null";
        }
        m = orderService.updateOrdedr(order);
        if(m > 0){
            return "update Order Success";
        }else{
            return "update Order Fail";
        }
    }

    /*删除订单信息*/
    @RequestMapping(value = "/deleteOrder/{id}",method = RequestMethod.DELETE)
    public String deleteOrder(@PathVariable(value = "id")Long id){
        int m = orderService.deleteOrder(id);
        if(m > 0){
            return "delete Order Success";
        }else{
            return "delete Order Fail";
        }
    }
}
