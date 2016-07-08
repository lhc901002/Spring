package org.mliuframework.spring.demo.onlineshopping.dao;

import org.mliuframework.spring.demo.onlineshopping.entity.Address;

import java.util.List;

/**
 * Created by Michael on 6/25/16.
 */
public interface AddressMapper {

    Address selectByPrimaryKey(Long id);

    List<Address> selectAll();

    List<Address> selectByProperties(Address address);

    List<Address> selectByCustomerId(Long customerId);

    int insert(Address address);

    int insertSelective(Address address);

    int updateByPrimaryKeySelective(Address address);

}
