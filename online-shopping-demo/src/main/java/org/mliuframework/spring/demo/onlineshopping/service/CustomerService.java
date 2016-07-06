package org.mliuframework.spring.demo.onlineshopping.service;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.demo.onlineshopping.dao.CustomerMapper;
import org.mliuframework.spring.demo.onlineshopping.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 6/27/16.
 */
@Service
public class CustomerService {

    private static final Log log = LogFactory.getLog(CustomerService.class);

    @Autowired
    private CustomerMapper customerMapper;

    public Customer saveOrUpdateSelective(Customer customer) throws Exception {
        try {
            if (null == customer.getId()) {
                if (StringUtils.isEmpty(customer.getPhoneNo()) ||
                        StringUtils.isEmpty(customer.getEmail())) {
                    throw new IllegalArgumentException("Phone Number and email cannot be empty!");
                } else {
                    Customer customerResultEntity = customerMapper.selectByPhoneNo(customer.getPhoneNo());
                    if (customerResultEntity != null) {
                        throw new IllegalStateException("Phone Number already exists!");
                    }
                    customerResultEntity = customerMapper.selectByEmail(customer.getEmail());
                    if (customerResultEntity != null) {
                        throw new IllegalStateException("Email already exists!");
                    }
                }
                customerMapper.insertSelective(customer);
            } else {
                customerMapper.updateByPrimaryKeySelective(customer);
            }
        } catch (Exception e) {
            log.error("saveOrUpdate throws exception: ", e);
            throw e;
        }
        return customer;
    }

    public Customer findById(Long id) {
        return customerMapper.selectByPrimaryKey(id);
    }

}
