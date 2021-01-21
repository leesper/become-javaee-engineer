package com.spring.dao;

import com.spring.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountDao {
    void save(Account account);
    void delete(@Param("id") Integer id);
    void update(Account account);
    Account findById(@Param("id") Integer id);
    Account findByName(@Param("name") String name);
    List<Account> findAll();
}
