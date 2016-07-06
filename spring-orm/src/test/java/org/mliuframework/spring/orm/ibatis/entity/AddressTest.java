package org.mliuframework.spring.orm.ibatis.entity;

import com.alibaba.fastjson.JSON;

/**
 * Created by Michael on 6/29/16.
 */
public class AddressTest {

    public static void main(String[] args) {
        Address address = new Address.Builder().setCustomerId(123456789l).setType((byte)1).build();
        System.out.println(JSON.toJSONString(address));
    }

}
