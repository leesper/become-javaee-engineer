package com.spring;

import com.spring.dao.AccountDao;
import com.spring.dao.impl.AccountDaoImpl;
import com.spring.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceTest {
    @Test
    public void testSaveAccount() {
        // 解析bean配置文件，把bean标签中的id和class存到Spring框架维护的map集合中
        // 这个map集合称为Spring容器
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("beans.xml");

        AccountService accountService = (AccountService)
                applicationContext.getBean("accountService");
        accountService.saveAccount();
    }

    @Test
    public void testGetBean() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("beans.xml");

        AccountDao accountDao = (AccountDao) ac.getBean("accountDao");
        System.out.println(accountDao);
        accountDao.saveAccount();

        AccountDao accountDao2 = (AccountDao) ac.getBean(AccountDao.class);
        System.out.println(accountDao2);
        accountDao2.saveAccount();

        AccountDao accountDao3 = (AccountDao) ac.getBean("accountDao",
                AccountDaoImpl.class);
        System.out.println(accountDao3);
        accountDao3.saveAccount();
    }

    @Test
    public void testInit() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("beans.xml");

        AccountDao accountDao = (AccountDao) ac.getBean("accountDao");
        System.out.println("accountDao=" + accountDao);
    }

    @Test
    public void testConstructorArg() {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService2");
        accountService.saveAccount();
    }

    @Test
    public void testSetter() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService3");
        accountService.saveAccount();
    }

    @Test
    public void testCollections() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService4");
        accountService.saveAccount();
    }
}
