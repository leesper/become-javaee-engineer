package com.kkb.service;

import com.kkb.pojo.TUser;

public interface UserService {
    TUser findByUserName(String userName);
}
