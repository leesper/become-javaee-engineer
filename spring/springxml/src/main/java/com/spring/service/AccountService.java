package com.spring.service;

import com.spring.pojo.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);
    void delete(Integer id);
    void update(Account account);
    Account findById(Integer id);
    Account findByName(String name);
    List<Account> findAll();
}
