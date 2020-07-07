package dyliang.service.impl;

import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import dyliang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)//只读型事务的配置
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        try {
            List<Account> accounts = accountDao.findAll();
            return accounts;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    @Override
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
