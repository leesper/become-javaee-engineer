package com.mybatis.dao;

import com.mybatis.pojo.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {
    @Select("SELECT * FROM orders WHERE userid=#{userid}")
    List<Order> findByUserid(Integer userid);

}
