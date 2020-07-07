package dyliang.dao;

import dyliang.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {

    List<Account> findAll();

    Account findByName(String name) throws SQLException;

    void updateAccount(Account account);
}
