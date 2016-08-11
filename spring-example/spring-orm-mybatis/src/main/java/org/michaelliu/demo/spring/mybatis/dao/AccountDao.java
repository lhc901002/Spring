package org.michaelliu.demo.spring.mybatis.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.michaelliu.demo.spring.mybatis.dto.Account;
import org.michaelliu.demo.spring.mybatis.vo.AccountVo;

import java.util.List;

/**
 * Created by Michael on 7/13/16.
 */
public interface AccountDao {

    AccountVo findById(Long id);

    List<AccountVo> findByName(String name);

    List<AccountVo> findByIdList(List<Long> idList);

    int saveSelective(Account account);

    int updateByIdSelective(Account account);

    List findPageListByName(String name, PageBounds pageBounds);

    List findPageListByIdList(List<Long> idList, PageBounds pageBounds);

}
