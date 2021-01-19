package com.spring;

//import com.spring.config.SpringConfig;
import com.spring.config.SpringConfigImproved;
import com.spring.pojo.Account;
import com.spring.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigImproved.class)
public class CRUDTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void findByName(){
        Account account = accountService.findByName("迪丽热巴");
        System.out.println("account = " + account);
    }

    @Test
    public void findAll(){
        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println("account = " + account);
        }
    }
}
