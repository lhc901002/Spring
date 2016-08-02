package org.michaelliu.spring.ioc.xml.service;

import org.michaelliu.spring.beans.Account;
import org.michaelliu.spring.ioc.xml.dao.AccountDao;
import org.michaelliu.spring.ioc.xml.dao.AnotherAccountDao;

/**
 * Created by michael on 2016/8/2.
 *
 * We must add getter and setter, otherwise, xml config won't work.
 */
public class AccountService {

    private AccountDao accountDao;

    private AnotherAccountDao myAccountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public AnotherAccountDao getMyAccountDao() {
        return myAccountDao;
    }

    public void setMyAccountDao(AnotherAccountDao myAccountDao) {
        this.myAccountDao = myAccountDao;
    }

    public Account findById(Long id) {
        return accountDao.selectById(id);
    }

    public Account findByName(String name) {
        return  myAccountDao.selectByName(name);
    }

}
