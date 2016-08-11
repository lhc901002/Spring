package org.michaelliu.demo.spring.webmvc.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.demo.spring.webmvc.vo.AccountVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by michael on 2016/8/9.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private static final Log log = LogFactory.getLog(AccountController.class);

    /**
     * http://localhost:8080/account/post
     */
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    @ResponseBody
    public AccountVo post(@RequestBody AccountVo account) {
        log.info("post receives: " + account);
        return account;
    }

}
