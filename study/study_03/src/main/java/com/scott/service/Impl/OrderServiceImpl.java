package com.scott.service.Impl;

import com.scott.dao.IOrderDao;
import com.scott.entity.Order;
import com.scott.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @CLASSNAME :OrderServiceImpl
 * @Description :数据实现层
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  15:13
 * @Version :V1.0
 * @Status : 编写
 **/
@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    IOrderDao orderDao;

    /*查询*/
    public List<Order> selectAllOrders(){
        return orderDao.selectAllOrders();
    }

    public Order selectById(Long id){
        return orderDao.selectById(id);
    }

    /*添加*/
    public int addOrder(Order order){
       return orderDao.addOrder(order);
    }

    /*修改*/
    public int updateOrdedr(Order order){
        return orderDao.updateOrdedr(order);
    }

    /*删除*/
    public int deleteOrder(Long id){
        return orderDao.deleteOrder(id);
    }

}
