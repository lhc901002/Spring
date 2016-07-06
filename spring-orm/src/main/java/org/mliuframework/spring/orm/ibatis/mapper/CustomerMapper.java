package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.entity.Customer;

import java.util.List;

/**
 * Created by Michael on 6/25/16.
 */
public interface CustomerMapper {

    Customer selectByPrimaryKey(Long id);

    List<Customer> selectByProperties(Customer customer);

    Customer selectByPhoneNo(String phoneNo);

    Customer selectByEmail(String email);

    List<Customer> selectAll();

    void insert(Customer customer);

    void insertSelective(Customer customer);

    int updateByPrimaryKeySelective(Customer customer);

}
