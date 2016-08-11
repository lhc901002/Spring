package org.michaelliu.spring.mybatis.dao.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.michaelliu.spring.beans.dto.Transaction;
import org.michaelliu.spring.beans.vo.TransactionVo;
import org.michaelliu.spring.mybatis.dao.TransactionDao;
import org.michaelliu.spring.mybatis.mapper.TransactionMapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 8/10/16.
 */
@Repository("bankChinaTransactionDao")
public class BankChinaTransactionDaoImpl extends SqlSessionDaoSupport implements TransactionDao {

    @Resource(name = "bankChinaTransactionMapper")
    private TransactionMapper transactionMapper;

    @Resource(name = "bankChinaSqlSessionFactory")
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public TransactionVo findById(Long id) {
        return transactionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TransactionVo> findByFromAccountId(Long fromAccountId) {
        return transactionMapper.selectByFromAccountId(fromAccountId);
    }

    @Override
    public List<TransactionVo> findByIdList(List<Long> idList) {
        return transactionMapper.selectByIdList(idList);
    }

    @Override
    public int saveSelective(Transaction transaction) {
        return transactionMapper.insertSelective(transaction);
    }

    @Override
    public int updateByIdSelective(Transaction transaction) {
        return transactionMapper.updateByPrimaryKeySelective(transaction);
    }

    @Override
    public List findPageListByAccountId(Long accountId, PageBounds pageBounds) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("accountId", accountId);
        return getSqlSession().selectList("org.michaelliu.spring.mybatis.mapper.TransactionMapper.selectByAccountId", params, pageBounds);
    }

    @Override
    public List findPageListByIdList(List<Long> idList, PageBounds pageBounds) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idList", idList);
        return getSqlSession().selectList("org.michaelliu.spring.mybatis.mapper.TransactionMapper.selectByIdList", params, pageBounds);
    }

}
