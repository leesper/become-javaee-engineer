package com.javaee.service;

import com.javaee.pojo.Account;
import java.util.List;

public interface AccountService {
    void save(Account account);
    void deleteById(Integer id);
    void update(Account account);
    Account findById(Integer id);
    List<Account> findAll();
}
