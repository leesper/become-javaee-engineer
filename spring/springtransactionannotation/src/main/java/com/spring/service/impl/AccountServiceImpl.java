package com.spring.service.impl;

import com.spring.dao.AccountDao;
import com.spring.pojo.Account;
import com.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String source, String target, double money) {
        Account sourceAccount = accountDao.findByName(source);
        Account targetAccount = accountDao.findByName(target);
        sourceAccount.setMoney( sourceAccount.getMoney() - money);
        targetAccount.setMoney( targetAccount.getMoney() + money );
        accountDao.update(sourceAccount);
        int i =1/0;
        accountDao.update(targetAccount);
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }

    @Override
    public void delete(Integer id) {
        accountDao.delete(id);
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public Account findByName(String name) {
        return accountDao.findByName(name);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
