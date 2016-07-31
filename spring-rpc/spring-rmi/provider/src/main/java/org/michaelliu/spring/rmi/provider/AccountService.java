package org.michaelliu.spring.rmi.provider;

import org.michaelliu.spring.beans.Account;

import java.util.List;

/**
 * Created by Michael on 7/14/16
 *
 * RMI: rmi://localhost:1199/rmi/AccountService
 */
public interface AccountService {

    void saveOrUpdate(Account account);

    List<Account> findAll();

}
