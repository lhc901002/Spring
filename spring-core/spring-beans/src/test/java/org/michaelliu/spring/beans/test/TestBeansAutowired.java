package org.michaelliu.spring.beans.test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.michaelliu.spring.beans.autowire.UsageAnnotationByName;
import org.michaelliu.spring.beans.autowire.UsageAnnotationByType;
import org.michaelliu.spring.beans.autowire.UsageConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Michael on 7/29/16.
 */
public class TestBeansAutowired {

    private static Log log = LogFactory.getLog(TestBeansAutowired.class);

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:config/beans-autowired.xml");
        // autowire by type
        UsageAnnotationByType usageAutowiredByType = ctx.getBean("usageAutowiredByType", UsageAnnotationByType.class);
        log.info(usageAutowiredByType);
        // autowire by name
        UsageAnnotationByName usageAutowiredByName = ctx.getBean("usageAutowiredByName", UsageAnnotationByName.class);
        log.info(usageAutowiredByName);
        // autowire by default (no)
        UsageConfiguration usageAutowiredByDefault = ctx.getBean("usageConfigurationByDefault", UsageConfiguration.class);
        log.info(usageAutowiredByDefault);
        // autowire by type
        UsageConfiguration usageAutowiredByType2 = ctx.getBean("usageConfigurationByType", UsageConfiguration.class);
        log.info(usageAutowiredByType2);
        // autowire by name
        UsageConfiguration usageAutowiredByName2 = ctx.getBean("usageConfigurationByName", UsageConfiguration.class);
        log.info(usageAutowiredByName2);
    }

}
