package org.michaelliu.spring.aop.service.impl;

import org.michaelliu.spring.aop.service.AccountService;
import org.michaelliu.spring.beans.SimpleAccount;

/**
 * Created by michael on 2016/7/31.
 */
public class AccountServiceImpl implements AccountService {

    @Override
    public SimpleAccount saveMoney(SimpleAccount account, Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be non-negative!");
        }
        account.setBalance(account.getBalance() + amount);
        return account;
    }

    @Override
    public SimpleAccount drawMoney(SimpleAccount account, Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount should be non-negative!");
        }
        account.setBalance(account.getBalance() - amount);
        return account;
    }

    @Override
    public Integer getBalance(SimpleAccount account) {
        return account.getBalance();
    }

}
