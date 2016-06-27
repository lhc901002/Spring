package org.mliuframework.spring.orm.ibatis.controller;

import com.alibaba.fastjson.JSON;
import org.mliuframework.spring.orm.ibatis.bo.Address;
import org.mliuframework.spring.orm.ibatis.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michael on 6/27/16.
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     *
     * @param address
     * @return
     *
     * http://localhost:8080/orm/address/saveAddress
     */
    @RequestMapping(value = "/saveAddress")
    @ResponseBody
    public String saveAddress(@RequestBody Address address) {
        Address rspAddress = addressService.saveOrUpdate(address);
        return JSON.toJSONString(rspAddress);
    }

}
