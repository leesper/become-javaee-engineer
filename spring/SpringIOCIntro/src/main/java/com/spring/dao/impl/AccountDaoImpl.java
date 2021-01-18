package com.spring.dao.impl;

import com.spring.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }

    @Override
    public void init() {
        System.out.println("init方法用于给对象属性赋值");
    }
}
