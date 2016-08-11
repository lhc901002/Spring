package org.michaelliu.spring.aop.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

/**
 * Created by michael on 2016/7/31.
 */
public class LogThrowAdvice implements ThrowsAdvice {

    private static Log log = LogFactory.getLog(LogThrowAdvice.class);

    public void afterThrowing(Exception e) throws Throwable {
        log.info("Account's transaction throws an Exception: " + e);
    }

}
