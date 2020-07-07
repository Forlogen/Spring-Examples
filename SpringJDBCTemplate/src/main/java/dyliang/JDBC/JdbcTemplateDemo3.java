package dyliang.JDBC;

import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateDemo3 {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao", IAccountDao.class);

        Account accountById = accountDao.findAccountById(1);
        System.out.println(accountById);
    }
}
