package org.mliuframework.spring.test;

import org.michaelliu.spring.beans.Usage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Michael on 7/15/16.
 */
public class TestBeans {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");
//        Account account = ctx.getBean("account1", Account.class);
//        System.out.println(account);
        Usage usage = ctx.getBean("usage", Usage.class);
        System.out.println(usage);
    }

}
