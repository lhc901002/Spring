package org.michaelliu.spring.rmi.provider;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by michael on 2016/8/4.
 */
public class RmiServiceProvider {

    private static final Log log = LogFactory.getLog(RmiServiceProvider.class);

    private static void init() {
        log.info("Rmi prepares to start...");
        new ClassPathXmlApplicationContext("classpath:config/remote-service.xml");
        log.info("Rmi has started...");
    }

    public static void main(String[] args) {
        init(); //won't break unless you force it stop.
    }

}
