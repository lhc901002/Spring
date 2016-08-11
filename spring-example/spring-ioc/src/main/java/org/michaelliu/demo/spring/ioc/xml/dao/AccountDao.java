package org.michaelliu.demo.spring.ioc.xml.dao;

import org.michaelliu.demo.spring.ioc.beans.Account;

/**
 * Created by michael on 2016/8/2.
 */
public class AccountDao {

    public Account selectById(Long id) {
        Account account = new Account();
        account.setId(id);
        return account;
    }

}
