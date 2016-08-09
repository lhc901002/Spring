package org.michaelliu.spring.ioc.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.Account;
import org.michaelliu.spring.ioc.annotation.config.ApplicationConfig;
import org.michaelliu.spring.ioc.annotation.service.AccountService;
import org.michaelliu.spring.ioc.annotation.service.MyAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by michael on 2016/8/2.
 */
public class TestAnnotationBeans {

    private static Log log = LogFactory.getLog(TestAnnotationBeans.class);

    public static void testAccount() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/annotation.xml");
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        Account account = accountService.findById(123l);
        log.info(account);
        account = accountService.findByName("Michael");
        log.info(account);
        MyAccountService myAccountService = appContext.getBean("myAccountService", MyAccountService.class);
        account = myAccountService.findByName("Steven");
        log.info(account);
    }

    public static void testAccountConfig() {
        ApplicationContext appContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
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
        testAccountConfig();
    }

}
