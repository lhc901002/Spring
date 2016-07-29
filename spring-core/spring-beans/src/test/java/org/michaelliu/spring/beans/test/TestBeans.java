package org.michaelliu.spring.beans.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Michael on 7/15/16.
 */
public class TestBeans {

    private static Log log = LogFactory.getLog(TestBeans.class);

    public static void main(String[] args) {
        // init-method will be invoked at this moment
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        Account account1 = ctx.getBean("account1", Account.class);
        log.info(account1);
        Account account2 = ctx.getBean("account2", Account.class);
        log.info(account2);
        Account account3 = ctx.getBean("account3", Account.class);
        log.info(account3);
        // destroy-method will be invoked at this moment
        ((ClassPathXmlApplicationContext) ctx).close();
    }

}
