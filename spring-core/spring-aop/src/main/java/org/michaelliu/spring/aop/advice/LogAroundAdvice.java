package org.michaelliu.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Arrays;

/**
 * Created by michael on 2016/7/31.
 */
public class LogAroundAdvice implements MethodInterceptor {

    private static Log log = LogFactory.getLog(LogAroundAdvice.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        log.info("Method name : " + methodInvocation.getMethod().getName());
        log.info("Method arguments : " + Arrays.toString(methodInvocation.getArguments()));
        Object result = methodInvocation.proceed();
        log.info("Method processing result : " + result);
        return result;
    }

}
