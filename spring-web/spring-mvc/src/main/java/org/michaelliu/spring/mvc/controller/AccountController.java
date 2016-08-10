package org.michaelliu.spring.mvc.controller;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by michael on 2016/8/9.
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    private static final Log log = LogFactory.getLog(AccountController.class);

//    @Resource(name = "accountService")
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    /**
     * http://localhost:8080/account/findByIdList
     */
    @RequestMapping(value = "/findByIdList", method = RequestMethod.POST)
    @ResponseBody
    public PageList findPageListByIdList(@RequestBody List<Long> idList) {
        log.info("findPageListByIdList receives: " + idList);
        PageList pageList = accountService.findPageListByIdList(idList, 1, 2);
        log.info("findPageListByIdList returns: " + JSON.toJSONString(pageList));
        return pageList;
    }

}
