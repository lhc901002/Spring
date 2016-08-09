package org.michaelliu.spring.remote.service;

import org.michaelliu.spring.beans.Account;

import java.util.List;

/**
 * Created by Michael on 7/14/16
 *
 * RMI: rmi://localhost:1199/rmi/AccountService
 * Hessian: http://localhost:8080/hessian/AccountService
 */
public interface AccountService {

    void saveOrUpdate(Account account);

    List<Account> findAll();

}
