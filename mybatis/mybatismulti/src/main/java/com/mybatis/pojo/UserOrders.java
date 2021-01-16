package com.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserOrders {
    private Integer id;
    private String username;
    private String sex;
    private String address;
    private List<Order> orders;
}
