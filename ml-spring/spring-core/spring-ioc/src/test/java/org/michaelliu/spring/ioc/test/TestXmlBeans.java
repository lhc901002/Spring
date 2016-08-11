package org.michaelliu.spring.ioc.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.Account;
import org.michaelliu.spring.ioc.xml.service.AccountService;
import org.michaelliu.spring.ioc.xml.service.MyAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by michael on 2016/8/2.
 */
public class TestXmlBeans {

    private static Log log = LogFactory.getLog(TestXmlBeans.class);

    public static void testAccount() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/beans.xml");
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        Account account = accountService.findById(123l);
        log.info(account);
        account = accountService.findByName("Michael");
        log.info(account);
        MyAccountService myAccountService = appContext.getBean("myAccountService", MyAccountService.class);
        account = myAccountService.findByName("Steven");
        log.info(account);
    }

    public static void main(String[] args) {
        testAccount();
    }

}
