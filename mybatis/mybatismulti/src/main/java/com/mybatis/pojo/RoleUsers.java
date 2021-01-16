package com.mybatis.pojo;

import lombok.Data;

import java.util.List;

@Data
public class RoleUsers {
    private Integer id;
    private String name;
    private List<User> users;
}
