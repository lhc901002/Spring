package org.michaelliu.spring.webservice.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.webservice.AccountService;
import org.michaelliu.spring.webservice.beans.Account;

import javax.jws.WebService;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Michael on 7/14/16.
 */
@WebService(endpointInterface = "org.michaelliu.spring.webservice.AccountService")
public class AccountServiceImpl implements AccountService {

    private static final Log log = LogFactory.getLog(AccountServiceImpl.class);

    @Override
    public void saveOrUpdate(Account account) {
        log.info("Account server receives: " + JSON.toJSONString(account));
    }

    @Override
    public List<Account> findAll() {
        List<Account> accountList = new LinkedList<>();
        accountList.add(new Account(1l, "Michael", 100));
        accountList.add(new Account(2l, "Steven", 200));
        accountList.add(new Account(3l, "Jackson", 200));
        log.info("Account server responses: " + JSON.toJSONString(accountList));
        return accountList;
    }

}
