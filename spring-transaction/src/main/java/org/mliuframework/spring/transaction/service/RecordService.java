package org.mliuframework.spring.transaction.service;

import org.mliuframework.spring.transaction.dao.RecordDao;
import org.mliuframework.spring.transaction.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 6/30/16.
 */
@Service
public class RecordService {

    @Autowired
    private RecordDao recordDao;

    public Record saveOrUpdateById(Record record) throws Exception {
        if (record == null) {
            throw new IllegalArgumentException("Record is null!");
        }
        try {
            if (null == record.getId()) {
                recordDao.insert(record);
            } else {
                recordDao.updateByIncreasingBalance(record.getId());
            }
            return record;
        } catch (Exception e) {
            throw e;
        }
    }

}
