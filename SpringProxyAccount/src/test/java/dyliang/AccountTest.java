package dyliang;

import dyliang.domain.Account;
import dyliang.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {

    @Autowired
//    @Qualifier("accountService")
    @Qualifier("proxyAccountService")
    private IAccountService as;

    @Test
    public void testTransfer(){
        System.out.println("----------------------");
        List<Account> all = as.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        as.transfer("Forlogen","Kobe",100f);

        System.out.println("----------------------");
        List<Account> all1 = as.findAll();
        for (Account account : all1) {
            System.out.println(account);
        }
    }
    /*
    ----------------------
    Account{id=1, name='Forlogen', money=1000.0}
    Account{id=2, name='Kobe', money=1000.0}
    Account{id=3, name='James', money=1000.0}
    ----------------------
    Account{id=1, name='Forlogen', money=900.0}
    Account{id=2, name='Kobe', money=1100.0}
    Account{id=3, name='James', money=1000.0}
     */
}

