package org.michaelliu.spring.jta.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.jta.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Michael on 8/9/16.
 */
public class TestAccountService {

    private static final Log log = LogFactory.getLog(TestAccountService.class);

    private ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");

    private AccountService accountService = context.getBean("accountService", AccountService.class);

    public void testSave() {
        try {
            accountService.saveEntry(new Account("Smith", 334), new Account("Ted", 27));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TestAccountService().testSave();
    }

}
