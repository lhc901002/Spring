package org.michaelliu.spring.mybatis.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.beans.vo.AccountVo;

import java.util.List;

/**
 * Created by Michael on 7/8/16.
 */
public interface AccountService {

    int saveOrUpdateSelective(Account account) throws Exception;

    AccountVo findById(Long id);

    List<AccountVo> findByName(String name);

    PageList findPageListByName(String name, Integer page, Integer pageSize);

    PageList findPageListByIdList(List<Long> idList, Integer page, Integer pageSize);

}