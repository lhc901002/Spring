package org.michaelliu.demo.spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Michael on 8/9/16.
 */
public class TimeAroundAdvice implements MethodInterceptor {

    private static Log log = LogFactory.getLog(TimeAroundAdvice.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = methodInvocation.proceed();
        long endTime = System.currentTimeMillis();
        log.info(methodInvocation.getMethod().getName() + " costs: " + (endTime - startTime) + " ms");
        return result;
    }

}
