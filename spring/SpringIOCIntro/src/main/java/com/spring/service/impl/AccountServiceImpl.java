package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.dao.impl.AccountDaoImpl;
import com.spring.service.AccountService;

public class AccountServiceImpl implements AccountService {
    // FIXME: needs to decouple with spring framework
    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
