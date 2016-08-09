package org.michaelliu.spring.mybatis.dao.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.ibatis.session.SqlSessionFactory;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.beans.vo.AccountVo;
import org.michaelliu.spring.mybatis.dao.AccountDao;
import org.michaelliu.spring.mybatis.mapper.AccountMapper;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Michael on 8/9/16.
 */
@Repository("accountDao")
public class AccountDaoImpl extends SqlSessionDaoSupport implements AccountDao {

    @Resource
    private AccountMapper accountMapper;

    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public AccountVo findById(Long id) {
        return accountMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AccountVo> findByName(String name) {
        return accountMapper.selectByName(name);
    }

    @Override
    public List<AccountVo> findByIdList(List<Long> idList) {
        return accountMapper.selectByIdList(idList);
    }

    @Override
    public int saveSelective(Account account) {
        return accountMapper.insertSelective(account);
    }

    @Override
    public int updateByIdSelective(Account account) {
        return accountMapper.updateByPrimaryKeySelective(account);
    }

    @Override
    public List findPageListByName(String name, PageBounds pageBounds){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        return getSqlSession().selectList("org.michaelliu.spring.mybatis.mapper.AccountMapper.selectByName", params, pageBounds);
    }

    @Override
    public List findPageListByIdList(List<Long> idList, PageBounds pageBounds){
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("idList", idList);
        return getSqlSession().selectList("org.michaelliu.spring.mybatis.mapper.AccountMapper.selectByIdList", params, pageBounds);
    }

}
