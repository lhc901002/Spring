package org.michaelliu.demo.spring.aop.service;

import org.michaelliu.demo.spring.aop.vo.Account;

/**
 * Created by michael on 2016/7/31.
 */
public interface AccountService {

    Account saveMoney(Account account, Integer amount);

    Account drawMoney(Account account, Integer amount);

    Integer getBalance(Account account);

}
