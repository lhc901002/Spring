package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.bo.Address;

import java.util.List;

/**
 * Created by Michael on 6/25/16.
 */
public interface AddressMapper {

    Address selectByPrimaryKey(Long id);

    List<Address> selectAll();

    Long insert(Address address);

    Long insertSelective(Address address);

    void updateByPrimaryKeySelective(Address address);

}
