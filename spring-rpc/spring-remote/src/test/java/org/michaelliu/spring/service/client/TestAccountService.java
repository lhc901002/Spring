package org.michaelliu.spring.service.client;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by michael on 2016/8/9.
 */
public class TestAccountService {

    private static final Log log = LogFactory.getLog(TestAccountService.class);

    private ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/remote-service.xml");

    private AccountService accountService = appContext.getBean("accountService", AccountService.class);

    private void testSaveAccount() {
        try {
            int result = accountService.saveOrUpdateSelective(new Account("Michael", 500));
            log.info("saveOrUpdateSelective result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestAccountService().testSaveAccount();
    }

}
