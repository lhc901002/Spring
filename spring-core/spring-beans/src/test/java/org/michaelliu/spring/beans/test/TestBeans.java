package org.michaelliu.spring.beans.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.Account;
import org.michaelliu.spring.beans.Usage;
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
        Account account = ctx.getBean("account1", Account.class);
        log.info(account);
        Usage usage = ctx.getBean("usage", Usage.class);
        log.info(usage);
        // destroy-method will be invoked at this moment
        ((ClassPathXmlApplicationContext) ctx).close();
    }

}
