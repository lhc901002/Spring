package org.michaelliu.spring.beans;

/**
 * Created by Michael on 7/15/16.
 */
public class AccountFactory {

    public Account createAccount(Long id, String name, UserInfo userInfo) {
        Account account = new Account();
        account.setId(id);
        account.setName(name);
        account.setUserInfo(userInfo);
        return account;
    }

}
