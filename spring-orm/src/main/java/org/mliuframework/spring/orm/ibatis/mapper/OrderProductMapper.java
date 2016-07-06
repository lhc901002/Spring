package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.entity.OrderProduct;

import java.util.List;

/**
 * Created by Michael on 7/1/16.
 */
public interface OrderProductMapper {

    OrderProduct selectByPrimaryKey(Long id);

    List<OrderProduct> selectAll();

    void insert(OrderProduct orderProduct);

    void insertSelective(OrderProduct orderProduct);

}
