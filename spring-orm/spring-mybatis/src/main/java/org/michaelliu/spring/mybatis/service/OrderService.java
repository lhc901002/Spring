package org.michaelliu.spring.mybatis.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.mybatis.mapper.OrderMapper;
import org.michaelliu.spring.mybatis.mapper.OrderProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Michael on 7/29/16.
 */
@Service
public class OrderService {

    private static final Log log = LogFactory.getLog(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderProductMapper orderProductMapper;


}
