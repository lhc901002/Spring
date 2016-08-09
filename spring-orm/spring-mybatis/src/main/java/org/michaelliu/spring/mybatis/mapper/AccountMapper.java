package org.michaelliu.spring.mybatis.mapper;

import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.beans.vo.AccountVo;

import java.util.List;

/**
 * Created by Michael on 8/9/16.
 */
public interface AccountMapper {

    AccountVo selectByPrimaryKey(Long id);

    List<AccountVo> selectByName(String name);

    List<AccountVo> selectByIdList(List<Long> idList);

    int insertSelective(Account account);

    int updateByPrimaryKeySelective(Account account);

}
