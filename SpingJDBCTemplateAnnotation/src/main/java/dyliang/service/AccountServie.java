package dyliang.service;

import config.SpringConfiguration;
import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServie {

    @Autowired
    private static IAccountDao accountDao;

    public static void main(String[] args) {
        Account accountById = accountDao.findAccountById(1);
        System.out.println(accountById);
    }
}
