package com.scott.service;

import com.scott.entity.Order;

import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 * Describ:数据库实现接口
 */
public interface IOrderService {
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
