package com.spring;

import com.spring.dao.AccountDao;
import com.spring.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestIOC {
    @Test
    public void testIOC() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean(AccountService.class);
        AccountDao accountDao = context.getBean(AccountDao.class);

        System.out.println(accountService);
        System.out.println(accountDao);

        context.close();
    }
}
