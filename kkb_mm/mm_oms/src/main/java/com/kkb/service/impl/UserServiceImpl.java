package com.kkb.service.impl;

import com.kkb.mapper.TUserMapper;
import com.kkb.pojo.TUser;
import com.kkb.pojo.TUserExample;
import com.kkb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TUserMapper userMapper;

    @Override
    public TUser findByUserName(String userName) {
        TUserExample example = new TUserExample();
        TUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName);

        List<TUser> users = userMapper.selectByExample(example);

        return users.isEmpty() ? null : users.get(0);
    }
}
