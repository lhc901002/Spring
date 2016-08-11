package org.michaelliu.demo.spring.jdbctemplate.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.spring.jdbctemplate.dto.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Michael on 7/13/16.
 */
@Repository
public class AccountDao {

    private static final Log log = LogFactory.getLog(AccountDao.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Account account) {
        log.info("insert receives: " + account);
        String sql = "INSERT INTO tb_account (name, balance) VALUES (?, ?)";
        return jdbcTemplate.update(sql, new Object [] { account.getName(),
                account.getBalance() });
    }

}
