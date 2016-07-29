package org.michaelliu.spring.beans.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.Usage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Michael on 7/29/16.
 */
public class TestBeansAutowired {

    private static Log log = LogFactory.getLog(TestBeansAutowired.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/beans-autowired.xml");
        // autowired by type
        Usage usageByDefaultAutowire = ctx.getBean("usageAutowiredByDefault", Usage.class);
        log.info(usageByDefaultAutowire);
        Usage usageAutowiredByName = ctx.getBean("usageAutowiredByName", Usage.class);
        log.info(usageAutowiredByName);
    }

}
