package com.spring.dao.impl;

import com.spring.dao.AccountDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository("accountDao")
@Scope("prototype")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void save() {
        System.out.println("保存了账户");
    }

    @PostConstruct
    public void init() {
        System.out.println("AccountDaoImpl对象创建完毕后执行初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("AccountDaoImpl对象销毁钱执行销毁方法");
    }
}
