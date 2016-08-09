package org.michaelliu.spring.jta.dao.impl;

import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.jta.dao.AccountUsDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Michael on 8/9/16.
 */
@Repository("accountUsDao")
public class AccountUsDaoImpl implements AccountUsDao {

    @Resource(name = "jdbcTemplateB")
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Account account) {
        String sql = "INSERT INTO tb_account (name, balance) values (?, ?)";
        return jdbcTemplate.update(sql, new Object [] { account.getName(), account.getBalance() });
    }

}
