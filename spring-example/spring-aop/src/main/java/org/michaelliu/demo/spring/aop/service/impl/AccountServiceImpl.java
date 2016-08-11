package org.michaelliu.demo.spring.aop.service.impl;

import org.michaelliu.demo.spring.aop.service.AccountService;
import org.michaelliu.demo.spring.aop.vo.Account;

/**
 * Created by michael on 2016/7/31.
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public Account saveMoney(Account account, Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be non-negative!");
        }
        account.setBalance(account.getBalance() + amount);
        return account;
    }

    @Override
    public Account drawMoney(Account account, Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be non-negative!");
        }
        account.setBalance(account.getBalance() - amount);
        return account;
    }

    @Override
    public Integer getBalance(Account account) {
        return account.getBalance();
    }

}
