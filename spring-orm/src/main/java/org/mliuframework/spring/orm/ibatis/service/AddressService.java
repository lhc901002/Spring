package org.mliuframework.spring.orm.ibatis.service;

import org.mliuframework.spring.orm.ibatis.bo.Address;
import org.mliuframework.spring.orm.ibatis.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 6/27/16.
 */
@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    public Address saveOrUpdate(Address address) {
        if (address.getId() == null) {
            Long newId = addressMapper.insertSelective(address);
            address.setId(newId);
        } else {
            addressMapper.updateByPrimaryKeySelective(address);
        }
        return address;
    }

}
