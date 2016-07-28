package org.michaelliu.spring.orm.mybatis.mapper;

import org.michaelliu.spring.beans.dto.Order;
import org.michaelliu.spring.beans.vo.OrderVo;

import java.util.List;

/**
 * Created by Michael on 6/29/16.
 */
public interface OrderMapper {

    OrderVo selectByPrimaryKey(Long id);

    List<OrderVo> selectByIdList(List<Long> idList);

    int insertSelective(Order order);

}
