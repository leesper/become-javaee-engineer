package com.javaee.dao;

import com.javaee.pojo.User;

public interface UserDao {
    User findById(Integer id);
}
