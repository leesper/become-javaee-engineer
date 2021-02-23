package com.javaee.dao;

import com.javaee.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User find(Integer id);
}
