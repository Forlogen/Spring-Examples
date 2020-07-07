package dyliang.dao.impl;

import dyliang.dao.IAccountDao;
import dyliang.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

public class IAccountImpl extends JdbcDaoSupport implements IAccountDao {

    public List<Account> findAll() {
        List<Account> accounts = getJdbcTemplate().query("select * from account",
                new BeanPropertyRowMapper<Account>(Account.class));
        return accounts;
    }

    public Account findByName(String name){
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }


    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set name=?,money=? where id=?",
                account.getName(),account.getMoney(),account.getId());
    }

}
