package com.spring;

import com.spring.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountServiceTest {
    //依赖注⼊
    @Autowired
    private AccountService accountService;
    /**
     * 测试转账
     */
    @Test
    public void testTransfer(){
        accountService.transfer("迪丽热巴","江疏影",100d);
    }
}
