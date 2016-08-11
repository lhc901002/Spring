package org.michaelliu.spring.mybatis.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Transaction;
import org.michaelliu.spring.beans.vo.AccountVo;
import org.michaelliu.spring.mybatis.dao.AccountDao;
import org.michaelliu.spring.mybatis.dao.TransactionDao;
import org.michaelliu.spring.service.TransactionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.sql.SQLException;

/**
 * Created by Michael on 8/10/16.
 */
@Service("transactionService")
@WebService(endpointInterface = "org.michaelliu.spring.service.TransactionService")
public class TransactionServiceImpl implements TransactionService {

    private static final Log log = LogFactory.getLog(TransactionServiceImpl.class);

    @Resource
    private TransactionDao transactionDao;

    @Resource
    private TransactionDao bankChinaTransactionDao;

    @Resource
    private TransactionDao bankUsTransactionDao;

    @Resource
    private AccountDao accountDao;

    @Resource
    private AccountDao bankChinaAccountDao;

    @Resource
    private AccountDao bankUsAccountDao;

    @Override
    public boolean saveInSameBank(Transaction transaction) throws Exception {
        log.info("saveInSameBank receives: " + transaction);
        try {
            AccountVo account1 = accountDao.findById(transaction.getFromAccountId());
            AccountVo account2 = accountDao.findById(transaction.getToAccountId());
            if (account1 == null || account2 == null) {
                throw new IllegalStateException("no such account");
            }
            if (account1.getBalance() <= 0) {
                throw new IllegalStateException("balance insufficient");
            }
            int result1 = accountDao.updateBalance(transaction.getFromAccountId(), 0 - transaction.getAmount());
            int result2 = accountDao.updateBalance(transaction.getToAccountId(), transaction.getAmount());
            int result3 = transactionDao.saveSelective(transaction);
            if (result1 > 0 && result2 > 0 && result3 > 0) {
                return true;
            } else {
                throw new SQLException("Transaction failed!");
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    @Override
    public boolean saveInDifferentBank(Transaction transaction) throws Exception {
        log.info("saveInDifferentBank receives: " + transaction);
        try {
            AccountVo accountVoBankChina = bankChinaAccountDao.findById(transaction.getFromAccountId());
            AccountVo accountVoBankUs = bankUsAccountDao.findById(transaction.getToAccountId());
            if (accountVoBankChina == null || accountVoBankUs == null) {
                throw new IllegalStateException("no such account");
            }
            if (accountVoBankChina.getBalance() <= 0) {
                throw new IllegalStateException("balance insufficient");
            }
            int result1 = bankChinaAccountDao.updateBalance(transaction.getFromAccountId(), 0 - transaction.getAmount());
            int result2 = bankUsAccountDao.updateBalance(transaction.getToAccountId(), transaction.getAmount());
            int result3 = bankChinaTransactionDao.saveSelective(transaction);
            int result4 = bankUsTransactionDao.saveSelective(transaction);
            if (result1 > 0 && result2 > 0 && result3 > 0 && result4 > 0) {
                return true;
            } else {
                throw new SQLException("Transaction failed!");
            }
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

}
