package com.javaee.dao;

import com.javaee.pojo.Account;

import java.util.List;

public interface AccountDao {
    void save(Account account);
    void deleteById(Integer id);
    void update(Account account);
    Account findById(Integer id);
    List<Account> findAll();
}
