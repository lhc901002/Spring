package org.mliuframework.spring.demo.onlineshopping.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.demo.onlineshopping.dao.AddressMapper;
import org.mliuframework.spring.demo.onlineshopping.dao.CustomerMapper;
import org.mliuframework.spring.demo.onlineshopping.entity.Address;
import org.mliuframework.spring.demo.onlineshopping.entity.Customer;
import org.mliuframework.spring.demo.onlineshopping.util.ConstantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        if (address == null) {
            throw new IllegalArgumentException("Address is null!");
        }
        try {
            if (null == address.getId()) {
                if (address.hasAllRequiredFields()) {
                    Customer customerResultEntity = customerMapper.
                            selectByPrimaryKey(address.getCustomerId());
                    if (null == customerResultEntity) {
                        throw new IllegalArgumentException("CustomerId does not exist!");
                    } else {
                        if (ConstantUtils.TYPE_ADDRESS_PERMANENT == address.getType()) {
                            Address addressQueryEntity = new Address.Builder().
                                    setCustomerId(address.getCustomerId()).setType(
                                    ConstantUtils.TYPE_ADDRESS_PERMANENT).setStatus(true).
                                    build();
                            List<Address> addressResultEntityList = addressMapper.
                                    selectByProperties(addressQueryEntity);
                            if (null != addressResultEntityList && !addressResultEntityList.isEmpty()) {
                                throw new IllegalStateException("One customer can only have " +
                                        "one permanent address!");
                            }
                        }
                        addressMapper.insertSelective(address);
                    }
                } else {
                    throw new IllegalArgumentException("Required fields missed for Address!");
                }
            } else {
                int result = addressMapper.updateByPrimaryKeySelective(address);
                if (result < 1) {
                    throw new IllegalStateException("Address Id does not exist!");
                }
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
