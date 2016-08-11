package org.michaelliu.spring.aop.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by michael on 2016/7/31.
 */
public class LogAfterAdvice implements AfterReturningAdvice {

    private static Log log = LogFactory.getLog(LogAfterAdvice.class);

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        log.info("Your account's transaction is completed!");
    }

}
