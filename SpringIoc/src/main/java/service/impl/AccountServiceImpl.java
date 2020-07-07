package service.impl;

import dao.IAccountDao;
import service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao accountDao;

    public AccountServiceImpl(){
        System.out.println("hello...");
    }
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
