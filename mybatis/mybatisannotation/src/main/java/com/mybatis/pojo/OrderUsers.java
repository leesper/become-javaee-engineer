package com.mybatis.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class OrderUsers {
    private Integer id;
    private Date ordertime;
    private Double total;
    private User user;
}
