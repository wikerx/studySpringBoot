package com.scott.mapper;

import com.scott.entity.OrderTest;
/*generator自动生成*/
public interface OrderTestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderTest record);

    int insertSelective(OrderTest record);

    OrderTest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderTest record);

    int updateByPrimaryKey(OrderTest record);
}