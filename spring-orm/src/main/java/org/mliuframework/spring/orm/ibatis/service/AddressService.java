package org.mliuframework.spring.orm.ibatis.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.orm.ibatis.bo.Address;
import org.mliuframework.spring.orm.ibatis.bo.Customer;
import org.mliuframework.spring.orm.ibatis.mapper.AddressMapper;
import org.mliuframework.spring.orm.ibatis.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 6/27/16.
 */
@Service
public class AddressService {

    private static final Log log = LogFactory.getLog(AddressService.class);

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private CustomerMapper customerMapper;

    public Address saveOrUpdateSelective(Address address) throws Exception {
        try {
            Address addressEntity = new Address();
            if (null == address.getId()) {
                if (null == address.getCustomerId()) {
                    throw new IllegalArgumentException("Parameter should include addressId " +
                            "or customerId!");
                } else {
                    Customer customerResultEntity = customerMapper.selectByPrimaryKey(address.getCustomerId());
                    if (null == customerResultEntity) {
                        throw new IllegalArgumentException("CustomerId does not exist!");
                    } else {
                        Long newId = addressMapper.insertSelective(addressEntity);
                        address.setId(newId);
                    }
                }
            } else {
                addressMapper.updateByPrimaryKeySelective(address);
            }
        } catch (Exception e) {
            log.error("saveOrUpdate throws exception: ", e);
            throw e;
        }
        return address;
    }

    public Address findById(Long id) {
        return addressMapper.selectByPrimaryKey(id);
    }

}
