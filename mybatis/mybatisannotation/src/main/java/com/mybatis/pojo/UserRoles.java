package com.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class UserRoles {
    private Integer id;
    private String username;
    private String sex;
    private String address;
    private List<Role> roles;
}
