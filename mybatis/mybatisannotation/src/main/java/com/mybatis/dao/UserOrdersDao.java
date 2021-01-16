package com.mybatis.dao;

import com.mybatis.pojo.Order;
import com.mybatis.pojo.UserOrders;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserOrdersDao {
    @Select("SELECT * FROM user")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "sex",  column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "orders",
                    javaType = List.class,
                    column = "id",
                    many = @Many(
                            fetchType = FetchType.LAZY,
                            select = "com.mybatis.dao.OrderDao.findByUserid"))
    })
    List<UserOrders> findAll();
}
