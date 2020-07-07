package dyliang.service.impl;

import dyliang.service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("saveAccount...");
    }

    public void updateAccount(int i) {
        System.out.println("updateAccount...");
    }

    public int deleteAccount() {
        System.out.println("deleteAccount...");
        return 0;
    }
}
