package org.michaelliu.spring.ioc.annotation.dao;

import org.michaelliu.spring.beans.Account;
import org.springframework.stereotype.Component;

/**
 * Created by michael on 2016/8/2.
 *
 * beans name is "newAccountDao"
 */
@Component("newAccountDao")
public class AnotherAccountDao {

    public Account selectByName(String name) {
        Account account = new Account();
        account.setName(name);
        return account;
    }

}
