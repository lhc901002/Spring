package org.michaelliu.spring.mybatis.mapper;

import org.michaelliu.spring.beans.dto.OrderProduct;

/**
 * Created by Michael on 7/1/16.
 */
public interface OrderProductMapper {

    OrderProduct selectByPrimaryKey(Long id);

    int insertSelective(OrderProduct orderProduct);

}
