package org.michaelliu.spring.aop.service;

import org.michaelliu.spring.beans.SimpleAccount;

/**
 * Created by michael on 2016/7/31.
 */
public interface AccountService {

    SimpleAccount saveMoney(SimpleAccount account, Integer amount);

    SimpleAccount drawMoney(SimpleAccount account, Integer amount);

}
