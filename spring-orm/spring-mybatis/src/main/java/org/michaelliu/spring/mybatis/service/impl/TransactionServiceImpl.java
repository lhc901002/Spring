package org.michaelliu.spring.mybatis.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Transaction;
import org.michaelliu.spring.mybatis.dao.AccountDao;
import org.michaelliu.spring.mybatis.dao.TransactionDao;
import org.michaelliu.spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * Created by Michael on 8/10/16.
 */
@Service("transactionService")
@WebService(endpointInterface = "org.michaelliu.spring.service.TransactionService")
public class TransactionServiceImpl implements TransactionService {

    private static final Log log = LogFactory.getLog(TransactionServiceImpl.class);

    @Autowired
    private TransactionDao transactionDao;

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean saveInSameBank(Long fromAccountId, Long toAccountId, Transaction transaction) throws Exception {
        log.info("saveInSameBank receives: " + fromAccountId + ", " + toAccountId + ", " + transaction);
        return false;
    }

    @Override
    public boolean saveInDifferentBank(Long fromAccountId, Long toAccountId, Transaction transaction) throws Exception {
        log.info("saveInDifferentBank receives: " + fromAccountId + ", " + toAccountId + ", " + transaction);
        return false;
    }

}
