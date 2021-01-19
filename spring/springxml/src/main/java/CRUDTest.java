import com.spring.pojo.Account;
import com.spring.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class CRUDTest {
    @Test
    public void testSave() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        Account account = new Account();
        account.setId(1);
        account.setName("迪丽热巴");
        account.setMoney(1000.0);
        accountService.save(account);
    }

    @Test
    public void testFindByName() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        Account account = accountService.findByName("迪丽热巴");
        System.out.println("account=" + account);
    }

    @Test
    public void testFindAll() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = ac.getBean(AccountService.class);
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println("account=" + account);
        }
    }
}
