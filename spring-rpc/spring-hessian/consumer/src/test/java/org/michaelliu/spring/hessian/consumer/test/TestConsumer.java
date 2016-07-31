package org.michaelliu.spring.hessian.consumer.test;

import com.alibaba.fastjson.JSON;
import org.michaelliu.spring.beans.Account;
import org.michaelliu.spring.hessian.provider.AccountService;
import org.michaelliu.spring.hessian.provider.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by michael on 2016/7/31.
 */
public class TestConsumer {

    private static void testMessageService() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        MessageService messageService = appContext.getBean("messageService", MessageService.class);
        String message = messageService.echo("Hello Michael");
        System.out.println("MessageService received: " + message);
    }

    private static void testAccountService() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        accountService.saveOrUpdate(new Account(123l, "Michael Liu"));
        List<Account> accountList = accountService.findAll();
        System.out.println("AccountService received: " + JSON.toJSONString(accountList));
    }

    public static void main(String[] args) {
        testMessageService();
        testAccountService();
    }

}
