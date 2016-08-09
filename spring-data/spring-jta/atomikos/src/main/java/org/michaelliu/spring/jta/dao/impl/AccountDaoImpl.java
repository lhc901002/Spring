package org.michaelliu.spring.jta.dao.impl;

import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.jta.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Michael on 8/9/16.
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Resource(name = "jdbcTemplateA")
    private JdbcTemplate jdbcTemplate;


    @Override
    public int insert(Account account) {
        String sql = "INSERT INTO tb_account (name, balance) values (?, ?)";
        return jdbcTemplate.update(sql, new Object [] { account.getName(), account.getBalance() });
    }

}
