package dyliang.dao.impl;

import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import dyliang.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class IAccountImpl implements IAccountDao {

    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<Account> findAll() {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        }catch (final Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String name){
        try {
            final List<Account> accounts = runner.query(connectionUtils.getThreadConnection(), "select * from account where name = ?",
                    new BeanListHandler<Account>(Account.class), name);
            if(accounts == null || accounts.size() == 0){
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("!-----");
            }
            return accounts.get(0);
        } catch (Throwable t){
            throw new RuntimeException(t);
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),
                    "update account set name=?,money=? where id=?",
                    account.getName(), account.getMoney(), account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
