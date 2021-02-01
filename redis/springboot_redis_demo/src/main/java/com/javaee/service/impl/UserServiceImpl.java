package com.javaee.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.javaee.entity.User;
import com.javaee.mapper.UserMapper;
import com.javaee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public User findById(Integer id) {
        Object userObject = redisTemplate.opsForValue().get("user:" + id);
        if (StringUtils.isEmpty(userObject)) {
            User user = userMapper.findById(id);
            System.out.println("从数据库中查出：" + user);
            if (!StringUtils.isEmpty(user)) {
                String userString = JSONObject.toJSONString(user);
                redisTemplate.opsForValue().set("user:" + id, userString,
                        5, TimeUnit.MINUTES);
                return user;
            } else {
                return null;
            }
        }

        User user = JSONObject.parseObject((String)userObject, User.class);
        System.out.println("从Redis中查出：" + (String) userObject);
        return user;
    }
}
