package dyliang.factory;

import dyliang.dao.impl.IAccountImpl;
import dyliang.service.IAccountService;
import dyliang.utils.TransactionManager;
import javafx.beans.value.ObservableObjectValue;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    AccountService的代理类
 */
public class BeanFactory {
    private IAccountService accountService;
    private TransactionManager txManager;

    public final void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public IAccountService getAccountService(){
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try{
                            txManager.beginTransaction();
                            rtValue= method.invoke(accountService, args);
                            txManager.commit();
                            return rtValue;
                        }
                        catch (Exception e){
                            txManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            txManager.release();
                        }
                    }
                });
    }
}
