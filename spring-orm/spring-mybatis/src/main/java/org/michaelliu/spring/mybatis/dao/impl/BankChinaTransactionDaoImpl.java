package org.michaelliu.spring.mybatis.dao.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.michaelliu.spring.beans.dto.Transaction;
import org.michaelliu.spring.beans.vo.TransactionVo;
import org.michaelliu.spring.mybatis.dao.TransactionDao;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by Michael on 8/10/16.
 */
public class BankChinaTransactionDaoImpl extends SqlSessionDaoSupport implements TransactionDao {
    @Override
    public TransactionVo findById(Long id) {
        return null;
    }

    @Override
    public List<TransactionVo> findByAccountId(Long accountId) {
        return null;
    }

    @Override
    public List<TransactionVo> findByIdList(List<Long> idList) {
        return null;
    }

    @Override
    public int saveSelective(Transaction transaction) {
        return 0;
    }

    @Override
    public int updateByIdSelective(Transaction transaction) {
        return 0;
    }

    @Override
    public List findPageListByAccountId(Long accountId, PageBounds pageBounds) {
        return null;
    }

    @Override
    public List findPageListByIdList(List<Long> idList, PageBounds pageBounds) {
        return null;
    }
}
