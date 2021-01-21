package com.spring.service.impl;

import com.spring.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("保存了账户");
    }
}
