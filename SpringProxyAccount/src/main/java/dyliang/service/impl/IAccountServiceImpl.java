package dyliang.service.impl;

import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import dyliang.service.IAccountService;
import dyliang.utils.TransactionManager;

import java.util.List;

public class IAccountServiceImpl implements IAccountService {

    private IAccountDao accountDao;
    private TransactionManager txManager;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }
    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /*
        此时存在的问题，每个问题都需要事务控制。
        因此，代码中都要调用txManager中的beginTransaction、commit、rollback和release
        当txManager所属的类中方法名改变时，所有的方法中使用到的地方都要手动进行更改

        解决办法：使用动态代理来生成增强代理类，见factory.BeanFactory方法
        在代理类执行业务层的方法时执行事务控制，此时事务控制就是增强操作
        而具体执行的方法不必自己管理事务控制
     */
    public List<Account> findAll() {
        try {
            txManager.beginTransaction();
            List<Account> accounts = accountDao.findAll();
            txManager.commit();
            return accounts;
        }catch (Exception e){
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            txManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
       try{
           txManager.beginTransaction();

           Account source = accountDao.findByName(sourceName);
           Account target = accountDao.findByName(targetName);
           source.setMoney(source.getMoney() - money);
           target.setMoney(target.getMoney() + money);

           accountDao.updateAccount(source);
//           int i = 1/0;
           accountDao.updateAccount(target);

           txManager.commit();
       } catch (Throwable t){
           txManager.rollback();
           throw new RuntimeException(t);
       } finally {
           txManager.release();
       }
    }
}
