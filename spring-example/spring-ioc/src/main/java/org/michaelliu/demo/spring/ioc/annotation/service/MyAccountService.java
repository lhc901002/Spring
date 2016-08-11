package org.michaelliu.demo.spring.ioc.annotation.service;

import org.michaelliu.demo.spring.ioc.annotation.dao.AnotherAccountDao;
import org.michaelliu.demo.spring.ioc.beans.Account;
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
