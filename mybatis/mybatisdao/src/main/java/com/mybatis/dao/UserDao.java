package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

public interface UserDao {
    User findById(Integer id);
    void save(User user);
    void deleteById(Integer id);
    void update(User user);
    List<User> findAll();
    List<User> findByName(String name);
    List<User> findByCondition(User user);
    List<User> findByIds(List<Integer> ids);
}
