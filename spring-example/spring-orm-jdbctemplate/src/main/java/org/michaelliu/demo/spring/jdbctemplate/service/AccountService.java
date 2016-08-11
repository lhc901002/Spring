package org.michaelliu.demo.spring.jdbctemplate.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.spring.jdbctemplate.dao.AccountDao;
import org.michaelliu.demo.spring.jdbctemplate.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 8/11/16.
 */
@Service
public class AccountService {

    private static final Log log = LogFactory.getLog(AccountService.class);

    @Autowired
    private AccountDao accountDao;

    public void save(Account account) throws Exception {
        try {
            accountDao.insert(account);
        } catch (Exception e) {
            throw e;
        }
    }

}
