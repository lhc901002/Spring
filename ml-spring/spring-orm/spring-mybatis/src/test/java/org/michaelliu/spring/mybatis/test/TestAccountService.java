package org.michaelliu.spring.mybatis.test;

import com.alibaba.fastjson.JSON;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.common.collect.Lists;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.beans.vo.AccountVo;
import org.michaelliu.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Michael on 8/9/16.
 */
public class TestAccountService {

    private static final Log log = LogFactory.getLog(TestAccountService.class);

    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");

    private AccountService accountService = context.getBean("accountService", AccountService.class);

    public void testSave() {
        try {
            int result = accountService.saveOrUpdateSelective(new Account("Michael", 500));
            log.info("saveOrUpdateSelective result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testFind() {
        AccountVo account = accountService.findById(1l);
        log.info(account);
        List<AccountVo> accountList = accountService.findByName("M");
        log.info(accountList);
        List<Long> idList = Lists.newArrayList();
        idList.add(1l);
        idList.add(2l);
        idList.add(3l);
        idList.add(4l);
        PageList accountPageList = accountService.findPageListByName("h", 1, 2);
        log.info(JSON.toJSONString(accountPageList));
        PageList accountPageList2 = accountService.findPageListByIdList(idList, 2, 2);
        log.info(JSON.toJSONString(accountPageList2));
    }

    public static void main(String[] args) {
//        new TestAccountService().testSave();
        new TestAccountService().testFind();
    }

}
