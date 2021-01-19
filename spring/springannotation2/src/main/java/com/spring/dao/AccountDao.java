package com.spring.dao;

import com.spring.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountDao {
    @Insert("INSERT INTO account VALUES(#{id}, #{name}, #{money})")
    void save(Account account);

    @Delete("DELETE FROM account WHERE id=#{id}")
    void delete(@Param("id") Integer id);

    @Update("UPDATE account SET name=#{name}, money=#{money} WHERE id=#{id}")
    void update(Account account);

    @Select("SELECT * FROM account WHERE id=#{id}")
    Account findById(@Param("id") Integer id);

    @Select("SELECT * FROM account WHERE name=#{name}")
    Account findByName(@Param("name") String name);

    @Select("SELECT * FROM account")
    List<Account> findAll();
}
