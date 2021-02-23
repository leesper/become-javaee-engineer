package com.javaee.service.impl;

import com.javaee.dao.UserDao;
import com.javaee.pojo.User;
import com.javaee.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User find(Integer id) {
        System.out.println("FIND");
        return userDao.find(id);
    }
}
