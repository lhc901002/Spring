package org.mliuframework.spring.demo.onlineshopping.controller;

import com.alibaba.fastjson.JSON;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mliuframework.spring.demo.onlineshopping.entity.Customer;
import org.mliuframework.spring.demo.onlineshopping.service.CustomerService;
import org.mliuframework.spring.demo.onlineshopping.util.ConstantUtils;
import org.mliuframework.spring.demo.onlineshopping.util.PropertyUtils;
import org.mliuframework.spring.demo.onlineshopping.vo.CustomerVo;
import org.mliuframework.spring.demo.onlineshopping.vo.RspCustomerVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private static final Log log = LogFactory.getLog(AddressController.class);

    @Autowired
    private CustomerService customerService;

    /**
     * http://localhost:8080/orm/customer/save
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public RspCustomerVo doSave(@RequestBody Customer customer) {
        log.info("doSave customer receive: " + JSON.toJSONString(customer));
        RspCustomerVo rspVo = new RspCustomerVo();
        try {
            Customer customerEntity = customerService.saveOrUpdateSelective(customer);
            CustomerVo customerVo = new CustomerVo();
            BeanUtils.copyProperties(customerEntity, customerVo);
            rspVo.setCustomer(customerVo);
            rspVo.setStatus(ConstantUtils.STATUS_SUCCESS);
            rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                    ConstantUtils.STATUS_SUCCESS));
        } catch (Exception e) {
            log.error("doSave customer throws exception: " + e);
            rspVo.setStatus(ConstantUtils.STATUS_EXCEPTION);
            rspVo.setStatusInfo(PropertyUtils.getStatusInfo(ConstantUtils.STATUS_PREFIX +
                    ConstantUtils.STATUS_EXCEPTION) + ": " + e);
        }
        log.info("doSave customer return: " + JSON.toJSONString(rspVo));
        return rspVo;
    }

}
