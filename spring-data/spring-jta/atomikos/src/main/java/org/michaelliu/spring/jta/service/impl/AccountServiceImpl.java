package org.michaelliu.spring.jta.service.impl;

import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.jta.dao.AccountDao;
import org.michaelliu.spring.jta.dao.AccountUsDao;
import org.michaelliu.spring.jta.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Michael on 8/9/16.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Resource(name = "accountUsDao")
    private AccountUsDao accountUsDao;

    @Override
    public void saveEntry(Account account1, Account account2) throws Exception {
        try {
            accountDao.insert(account1);
            accountUsDao.insert(account2);
        } catch (Exception e) {
            throw e;
        }
    }

}
