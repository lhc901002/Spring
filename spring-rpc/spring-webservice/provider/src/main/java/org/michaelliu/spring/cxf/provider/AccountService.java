package org.michaelliu.spring.cxf.provider;

import org.michaelliu.spring.cxf.beans.Account;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Michael on 7/14/16
 *
 * WS: http://localhost:8080/webservice/AccountService?wsdl
 */
@WebService
public interface AccountService {

    void saveOrUpdate(Account account);

    List<Account> findAll();

}
