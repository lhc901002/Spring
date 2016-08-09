package org.michaelliu.spring.jta.service;

import org.michaelliu.spring.beans.dto.Account;

/**
 * Created by Michael on 8/9/16.
 */
public interface AccountService {

    void saveEntry(Account account1, Account account2) throws Exception;

}
