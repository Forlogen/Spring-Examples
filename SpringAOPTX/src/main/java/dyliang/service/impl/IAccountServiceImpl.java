package dyliang.service.impl;

import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import dyliang.service.IAccountService;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll() {
        try {
            List<Account> accounts = accountDao.findAll();
            return accounts;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
       try{
           Account source = accountDao.findByName(sourceName);
           Account target = accountDao.findByName(targetName);
           source.setMoney(source.getMoney() - money);
           target.setMoney(target.getMoney() + money);

           accountDao.updateAccount(source);
           accountDao.updateAccount(target);
       } catch (Throwable t){
           throw new RuntimeException(t);
       }
    }
}
