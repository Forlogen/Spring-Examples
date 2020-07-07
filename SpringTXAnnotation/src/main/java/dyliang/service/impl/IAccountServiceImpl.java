package dyliang.service.impl;

import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import dyliang.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service("accountService")
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class IAccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void transfer(final String sourceName, final String targetName, final Float money) {
        try {
            System.out.println("transfer....");
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
