package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.service.AccountService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void save() {
        accountDao.save();
    }
}
