package com.spring;

import com.spring.pojo.Account;
import com.spring.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringTransactionTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer(){
        accountService.transfer("迪丽热巴","江疏影",100d);
    }

    @Test
    public void testFindAll() {
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println("account=" + account);
        }
    }
}
