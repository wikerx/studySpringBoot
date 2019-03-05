package com.scott.dao;

import com.scott.entity.Order;

import java.util.List;

/**
 * @CLASSNAME :IOrderDao
 * @Description :数据库实现接口dao层
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  15:38
 * @Version :V1.0
 * @Status : 编写
 **/
public interface IOrderDao {
    /*查询*/
    List<Order> selectAllOrders();
    Order selectById(Long id);

    /*添加*/
    int addOrder(Order order);

    /*修改*/
    int updateOrdedr(Order order);

    /*删除*/
    int deleteOrder(Long id);
}
