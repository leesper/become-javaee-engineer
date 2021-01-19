package com.spring.dao;

import com.spring.pojo.Account;

import java.util.List;

public interface AccountDao {
    void save(Account account);
    void delete(Integer id);
    void update(Account account);
    Account findById(Integer id);
    Account findByName(String name);
    List<Account> findAll();
}
