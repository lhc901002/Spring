package org.mliuframework.spring.orm.ibatis.mapper;

import org.mliuframework.spring.orm.ibatis.bo.CustomerAddressRelation;

import java.util.List;

/**
 * Created by Michael on 6/25/16.
 */
public interface CustomerAddressRelationMapper {

    CustomerAddressRelation selectByPrimaryKey(Long id);

    List<CustomerAddressRelation> selectAll();

    CustomerAddressRelation insert(CustomerAddressRelation relation);

    CustomerAddressRelation insertSelective(CustomerAddressRelation relation);

    void updateByPrimaryKeySelective(CustomerAddressRelation relation);

}
