package dyliang.service;

import dyliang.domain.Account;

import java.util.List;

public interface IAccountService {

    List<Account> findAll();
    void transfer(String sourceName, String targetName, Float money);
}
