package org.michaelliu.spring.ioc.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.Account;
import org.michaelliu.spring.ioc.beans.Manager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by michael on 2016/8/3.
 */
public class TestIoc {

    private static Log log = LogFactory.getLog(TestIoc.class);

    public static void testCreateAccount() {
        // init-method will be invoked at this moment
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/beans-account.xml");
        Account accountBySetter = appContext.getBean("accountBySetter", Account.class);
        log.info("accountBySetter: " + accountBySetter);
        Account accountByConstructor = appContext.getBean("accountByConstructor", Account.class);
        log.info("accountByConstructor: " + accountByConstructor);
        Account accountByFactory = appContext.getBean("accountByFactory", Account.class);
        log.info("accountByFactory: " + accountByFactory);
        // destroy-method will be invoked at this moment
        ((ClassPathXmlApplicationContext) appContext).close();
    }

    public static void testCreateManager() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/beans-manager.xml");
        Manager manager = appContext.getBean("manager", Manager.class);
        log.info(manager);
    }

    public static void main(String[] args) {
        testCreateAccount();
        testCreateManager();
    }

}
