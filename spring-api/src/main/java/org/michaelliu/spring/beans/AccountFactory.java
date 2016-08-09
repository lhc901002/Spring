package org.michaelliu.spring.beans;

import java.util.Date;

/**
 * Created by Michael on 7/15/16.
 */
public class AccountFactory {

    public Account createAccount(Long id, String name, Integer balance) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setBalance(balance);
        account.setCreateTime(new Date());
        account.setUpdateTime(new Date());
        return account;
    }

}
