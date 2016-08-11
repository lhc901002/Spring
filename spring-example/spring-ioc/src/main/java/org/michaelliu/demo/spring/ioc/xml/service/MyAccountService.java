package org.michaelliu.demo.spring.ioc.xml.service;

import org.michaelliu.demo.spring.ioc.beans.Account;
import org.michaelliu.demo.spring.ioc.xml.dao.AnotherAccountDao;

/**
 * Created by michael on 2016/8/2.
 *
 * We must add getter and setter, otherwise, xml config won't work.
 */
public class MyAccountService {

    private AnotherAccountDao myAccountDao;

    public AnotherAccountDao getMyAccountDao() {
        return myAccountDao;
    }

    public void setMyAccountDao(AnotherAccountDao myAccountDao) {
        this.myAccountDao = myAccountDao;
    }

    public Account findByName(String name) {
        return  myAccountDao.selectByName(name);
    }

}
