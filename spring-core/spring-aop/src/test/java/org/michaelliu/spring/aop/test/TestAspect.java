package org.michaelliu.spring.aop.test;

import org.michaelliu.spring.aop.service.AccountService;
import org.michaelliu.spring.beans.SimpleAccount;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by michael on 2016/7/31.
 */
public class TestAspect {

    private static void testAdvice(SimpleAccount account) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "classpath:config/applicationContext.xml" });
        AccountService accountService = appContext.getBean("accountServiceProxy", AccountService.class);
        accountService.saveMoney(account, 100);
        accountService.drawMoney(account, 200);
        accountService.drawMoney(account, -20);
    }

    private static void testAspectAnnotation(SimpleAccount account) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "classpath:config/applicationContext.xml" });
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        accountService.saveMoney(account, 100);
        accountService.drawMoney(account, 200);
        accountService.drawMoney(account, -20);
    }

    private static void testAspectConfiguration(SimpleAccount account) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "classpath:config/application-aspect.xml" });
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        accountService.saveMoney(account, 100);
        accountService.drawMoney(account, 200);
        accountService.drawMoney(account, -20);
    }

    public static void main(String[] args) {
        SimpleAccount account = new SimpleAccount(123l, "Michael Liu", 400);
//        testAdvice(account);
//        testAspectAnnotation(account);
        testAspectConfiguration(account);
    }

}
