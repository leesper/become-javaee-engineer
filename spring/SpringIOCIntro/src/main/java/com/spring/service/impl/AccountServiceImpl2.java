package com.spring.service.impl;

import com.spring.service.AccountService;

import java.util.Date;

public class AccountServiceImpl2 implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl2() {}

    public AccountServiceImpl2(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("name=" + name);
        System.out.println("age=" + age);
        System.out.println("birthday=" + birthday);
    }
}
