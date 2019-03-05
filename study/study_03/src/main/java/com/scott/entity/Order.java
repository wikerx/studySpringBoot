package com.scott.entity;

/**
 * @CLASSNAME :Order
 * @Description :测试数据库中的表实体
 * @Author :Mr.薛
 * @Data :2019/3/5 0005  15:10
 * @Version :V1.0
 * @Status : 编写
 **/

public class Order {
    private Long id;
    private String orderNo;
    private String orderName;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
