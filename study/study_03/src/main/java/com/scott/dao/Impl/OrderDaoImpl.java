package com.scott.dao.Impl;

import com.scott.dao.IOrderDao;
import com.scott.entity.Order;
import com.scott.utils.GetOrderNo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @CLASSNAME :OrderDaoImpl
 * @Description :dao层数据库实现
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  15:38
 * @Version :V1.0
 * @Status : 编写
 **/
@Repository
public class OrderDaoImpl implements IOrderDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*查询*/
    @Override
    public List<Order> selectAllOrders(){
        List<Order> list = jdbcTemplate.query("select * from ordertest", new Object[]{}, new BeanPropertyRowMapper(Order.class));
        if (list.size()>0){
            return list;/*存在即显示*/
        }else{
            return null;
        }
    }
    @Override
    public Order selectById(Long id){
        List<Order> list = jdbcTemplate.query("select * from ordertest", new Object[]{}, new BeanPropertyRowMapper(Order.class));
        if (list.size()>0){
            Order order = list.get(0);/*存在即显示*/
            return order;
        }else{
            return null;
        }
    }

    /*添加*/
    @Override
    public int addOrder(Order order){
        int num = (int)(Math.random()*1000+1);
        return jdbcTemplate.update("INSERT INTO ordertest(orderNO,orderName,remark) VALUES (?,?,?)",
                order.getOrderNo(),order.getOrderName(),order.getRemark());
    }

    /*修改*/
    @Override
    public int updateOrdedr(Order order){
        int num = (int)(Math.random()*1000+1);
        return jdbcTemplate.update("UPDATE ordertest SET orderNO = ?,orderName = ?,remark =? WHERE id = ?",
                order.getOrderNo(),order.getOrderName(),order.getRemark(),order.getId());
    }

    /*删除*/
    @Override
    public int deleteOrder(Long id){return jdbcTemplate.update("DELETE FROM ordertest WHERE id = ?",id);}
}
