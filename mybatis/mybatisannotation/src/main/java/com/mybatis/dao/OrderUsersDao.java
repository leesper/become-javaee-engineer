package com.mybatis.dao;

import com.mybatis.pojo.OrderUsers;
import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderUsersDao {
    @Select("SELECT * FROM orders")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "total", column = "total"),
            @Result(property = "user",
                    javaType = User.class,
                    column = "userid",
                    one = @One(
                            fetchType = FetchType.LAZY,
                            select = "com.mybatis.dao.UserDao.findById"))
    })
    List<OrderUsers> findAll();

}
