package org.michaelliu.spring.hessian.provider;

import org.michaelliu.spring.beans.Account;

import java.util.List;

/**
 * Created by Michael on 7/14/16
 *
 * Hessian: http://localhost:8080/hessian/AccountService
 */
public interface AccountService {

    void saveOrUpdate(Account account);

    List<Account> findAll();

}
