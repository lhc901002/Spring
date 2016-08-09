package org.michaelliu.spring.jta.dao;

import org.michaelliu.spring.beans.dto.Account;

/**
 * Created by Michael on 8/9/16.
 */
public interface AccountDao {

    int insert(Account account);

}
