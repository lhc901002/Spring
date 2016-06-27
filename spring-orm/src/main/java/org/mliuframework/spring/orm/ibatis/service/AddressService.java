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
        Address rspAddress = null;
        if (address.getId() == null) {
            rspAddress = addressMapper.insertSelective(address);
        } else {
            addressMapper.updateByPrimaryKeySelective(address);
            rspAddress = address;
        }
        return rspAddress;
    }

}
