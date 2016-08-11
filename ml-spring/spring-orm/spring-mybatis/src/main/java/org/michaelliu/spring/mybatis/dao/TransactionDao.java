package org.michaelliu.spring.mybatis.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.michaelliu.spring.beans.dto.Transaction;
import org.michaelliu.spring.beans.vo.TransactionVo;

import java.util.List;

/**
 * Created by Michael on 8/10/16.
 */
public interface TransactionDao {

    TransactionVo findById(Long id);

    List<TransactionVo> findByFromAccountId(Long fromAccountId);

    List<TransactionVo> findByIdList(List<Long> idList);

    int saveSelective(Transaction transaction);

    int updateByIdSelective(Transaction transaction);

    List findPageListByAccountId(Long accountId, PageBounds pageBounds);

    List findPageListByIdList(List<Long> idList, PageBounds pageBounds);

}
