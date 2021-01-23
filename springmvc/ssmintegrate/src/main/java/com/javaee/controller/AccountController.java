package com.javaee.controller;

import com.javaee.pojo.Account;
import com.javaee.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService service) {
        accountService = service;
    }

    @RequestMapping("findAll")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @RequestMapping("save")
    public String save(@RequestBody Account account) {
        accountService.save(account);
        return "save success";
    }

    @RequestMapping("deleteById")
    public String deleteById(Integer id) {
        accountService.deleteById(id);
        return "delete success";
    }

    @RequestMapping("findById")
    public Account findById(Integer id) {
        return accountService.findById(id);
    }

    @RequestMapping("update")
    public String update(@RequestBody Account account) {
        accountService.update(account);
        return "update success";
    }
}
