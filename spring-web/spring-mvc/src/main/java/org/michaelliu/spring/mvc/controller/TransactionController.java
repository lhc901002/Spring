package org.michaelliu.spring.mvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by michael on 2016/8/10.
 */
@Controller
@RequestMapping("/transaction")
public class TransactionController {

    private static final Log log = LogFactory.getLog(TransactionController.class);

    //    @Resource(name = "transactionService")
    @Autowired
    @Qualifier("transactionService")
    private TransactionService transactionService;

}
