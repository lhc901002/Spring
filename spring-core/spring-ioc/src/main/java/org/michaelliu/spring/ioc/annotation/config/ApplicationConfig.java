package org.michaelliu.spring.ioc.annotation.config;

import org.michaelliu.spring.ioc.annotation.dao.AccountDao;
import org.michaelliu.spring.ioc.annotation.dao.AnotherAccountDao;
import org.michaelliu.spring.ioc.annotation.service.AccountService;
import org.michaelliu.spring.ioc.annotation.service.MyAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by michael on 2016/8/3.
 */
@Configuration
public class ApplicationConfig {

    @Bean
    public AccountDao accountDao() {
        return new AccountDao();
    }

    @Bean(name = "newAccountDao")
    public AnotherAccountDao anotherAccountDao() {
        return new AnotherAccountDao();
    }

    @Bean
    public AccountService accountService() {
        return new AccountService();
    }

    @Bean
    public MyAccountService myAccountService() {
        return new MyAccountService();
    }

}
