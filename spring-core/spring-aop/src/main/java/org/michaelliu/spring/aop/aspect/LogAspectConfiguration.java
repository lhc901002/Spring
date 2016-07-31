package org.michaelliu.spring.aop.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

/**
 * Created by michael on 2016/7/31.
 */
public class LogAspectConfiguration {

    private static Log log = LogFactory.getLog(LogAspectConfiguration.class);

    public void logBefore(JoinPoint joinPoint) {
        log.info("logBefore() executes: " + joinPoint.getSignature().getName());
    }

    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("logAround() executes: " + joinPoint.getSignature().getName());
        log.info("Method's arguments: " + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed(); //continue on the intercepted method
        log.info("Method's result : " + result);
    }

    public void logAfter(JoinPoint joinPoint) {
        log.info("logAfter() executes: " + joinPoint.getSignature().getName());
    }

    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("logAfterReturning() executes: " + joinPoint.getSignature().getName());
        log.info("Method returns: " + result);
    }

    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.info("logAfterThrowing() executes: " + joinPoint.getSignature().getName());
        log.info("Method throws: " + error);
    }

}
