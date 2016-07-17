package org.michaelliu.spring.transaction.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.transaction.dao.RecordDao;
import org.michaelliu.spring.transaction.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Michael on 6/30/16.
 */
@Service
public class RecordService {

    private static final Log log = LogFactory.getLog(RecordService.class);

    @Autowired
    private RecordDao recordDao;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public int updateByIncrease(Long id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("ID is null!");
        }
        int result = 0;
        try {
            Record recordResultEntry = recordDao.selectById(id);
            log.info(recordResultEntry.getBalance());
            result = recordDao.updateByIncreaseBalance(id, recordResultEntry.getBalance() + 1);
        } catch (Exception e) {
            throw e;
        }
        return result;
    }

    public int updateByAutoIncrease(Long id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("ID is null!");
        }
        try {
            return recordDao.updateByAutoIncrease(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public int updateByAutoDecrease(Long id) throws Exception {
        if (id == null) {
            throw new IllegalArgumentException("ID is null!");
        }
        try {
            return recordDao.updateByAutoDecrease(id);
        } catch (Exception e) {
            throw e;
        }
    }

}
