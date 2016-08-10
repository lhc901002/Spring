package org.michaelliu.spring.mybatis.mapper;

import org.michaelliu.spring.beans.dto.Transaction;
import org.michaelliu.spring.beans.vo.TransactionVo;

import java.util.List;

/**
 * Created by Michael on 8/10/16.
 */
public interface TransactionMapper {

    TransactionVo selectByPrimaryKey(Long id);

    List<TransactionVo> selectByAccountId(Long accountId);

    List<TransactionVo> selectByIdList(List<Long> idList);

    int insertSelective(Transaction transaction);

    int updateByPrimaryKeySelective(Transaction transaction);

}
