package org.michaelliu.spring.cxf.consumer.test;

import com.alibaba.fastjson.JSON;
import org.michaelliu.spring.cxf.beans.Account;
import org.michaelliu.spring.cxf.provider.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by michael on 2016/7/31.
 */
public class TestConsumer {

    private static void testAccountService() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("classpath:config/applicationContext.xml");
        AccountService accountService = appContext.getBean("accountService", AccountService.class);
        accountService.saveOrUpdate(new Account(123l, "Michael Liu"));
        List<Account> accountList = accountService.findAll();
        System.out.println("AccountService received: " + JSON.toJSONString(accountList));
    }

    public static void main(String[] args) {
        testAccountService();
    }

}
