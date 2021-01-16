package com.mybatis.pojo;

import lombok.Data;
import java.util.Date;

@Data
public class Order {
    private Integer id;
    private Date ordertime;
    private Double total;
}
