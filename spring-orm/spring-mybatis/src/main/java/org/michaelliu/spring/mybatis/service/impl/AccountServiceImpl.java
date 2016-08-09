package org.michaelliu.spring.mybatis.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.beans.vo.AccountVo;
import org.michaelliu.spring.mybatis.dao.AccountDao;
import org.michaelliu.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by Michael on 8/9/16.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private static final Log log = LogFactory.getLog(AccountService.class);

    @Autowired
    private AccountDao accountDao;

    @Override
    public int saveOrUpdateSelective(Account account) throws Exception {
        log.info("saveOrUpdateSelective receives: " + account);
        if (null == account) {
            throw new IllegalArgumentException("Account is null!");
        }
        int result;
        try {
            if (null == account.getId()) {
                result = accountDao.saveSelective(account);
            } else {
                account.setUpdateTime(new Date());
                result = accountDao.updateByIdSelective(account);
            }
        } catch (Exception e) {
            log.error("saveOrUpdateSelective exception: " + e);
            throw e;
        }
        return result;
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public AccountVo findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id is empty!");
        }
        return accountDao.findById(id);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<AccountVo> findByName(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("name is empty!");
        }
        return accountDao.findByName(name);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public PageList findPageListByName(String name, Integer page, Integer pageSize) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalArgumentException("name is empty!");
        }
        PageBounds pageBounds = new PageBounds(page, pageSize);
        List accountList = accountDao.findPageListByName(name, pageBounds);
        PageList accountPageList = (PageList) accountList;
        return accountPageList;
    }

    @Override
    public PageList findPageListByIdList(List<Long> idList, Integer page, Integer pageSize) {
        if (CollectionUtils.isEmpty(idList)) {
            throw new IllegalArgumentException("id list is empty!");
        }
        PageBounds pageBounds = new PageBounds(page, pageSize);
        List accountList = accountDao.findPageListByIdList(idList, pageBounds);
        PageList accountPageList = (PageList) accountList;
        return accountPageList;
    }

}
