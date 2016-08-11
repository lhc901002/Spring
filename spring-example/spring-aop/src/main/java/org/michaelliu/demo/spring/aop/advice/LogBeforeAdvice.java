package org.michaelliu.demo.spring.aop.advice;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by michael on 2016/7/31.
 */
public class LogBeforeAdvice implements MethodBeforeAdvice {

    private static Log log = LogFactory.getLog(LogBeforeAdvice.class);

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        log.info("Before processing your account...");
    }

}
