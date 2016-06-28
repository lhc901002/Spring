package org.mliuframework.spring.orm.ibatis.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.orm.ibatis.bo.Customer;
import org.mliuframework.spring.orm.ibatis.mapper.CustomerMapper;
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

    public Customer saveOrUpdate(Customer customer) throws Exception {
        try {
            if (null == customer.getId()) {
                Long newId = customerMapper.insertSelective(customer);
                customer.setId(newId);
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
