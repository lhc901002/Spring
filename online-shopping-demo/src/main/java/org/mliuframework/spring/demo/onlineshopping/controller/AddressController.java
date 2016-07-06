package org.mliuframework.spring.demo.onlineshopping.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.demo.onlineshopping.entity.Address;
import org.mliuframework.spring.demo.onlineshopping.service.AddressService;
import org.mliuframework.spring.demo.onlineshopping.util.ConstantUtils;
import org.mliuframework.spring.demo.onlineshopping.util.PropertyUtils;
import org.mliuframework.spring.demo.onlineshopping.vo.AddressVo;
import org.mliuframework.spring.demo.onlineshopping.vo.RspAddressVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Michael on 6/27/16.
 */
@Controller
@RequestMapping("/address")
public class AddressController {

    private static final Log log = LogFactory.getLog(AddressController.class);

    @Autowired
    private AddressService addressService;

    /**
     * http://localhost:8080/orm/address/save
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RspAddressVo doSave(@RequestBody Address address) {
        log.info("doSave address receive: " + JSON.toJSONString(address));
        RspAddressVo rspVo = new RspAddressVo();
        try {
            Address addressEntity = addressService.saveOrUpdateSelective(address);
            AddressVo addressVo = new AddressVo();
            BeanUtils.copyProperties(addressEntity, addressVo);
            rspVo.setAddress(addressVo);
            rspVo.setStatus(ConstantUtils.STATUS_SUCCESS);
            rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                    ConstantUtils.STATUS_SUCCESS));
        } catch (Exception e) {
            log.error("doSave address throws exception: " + e);
            rspVo.setStatus(ConstantUtils.STATUS_FAIL);
            rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                    ConstantUtils.STATUS_EXCEPTION) + ": " + e);
        }
        log.info("doSave address return: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

}
