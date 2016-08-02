package org.michaelliu.spring.ioc.annotation.service;

import org.michaelliu.spring.beans.Account;
import org.michaelliu.spring.ioc.annotation.dao.AnotherAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by michael on 2016/8/2.
 */
@Component
public class MyAccountService {

    // @Qualifier makes autowired by name
    @Autowired
    @Qualifier("newAccountDao")
    private AnotherAccountDao accountDao;

    public Account findByName(String name) {
        return  accountDao.selectByName(name);
    }

}
