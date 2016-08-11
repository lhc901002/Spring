package org.michaelliu.demo.spring.aop.aspect;

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

    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        log.info("logAround() executes: " + method);
        log.info(method + " arguments: " + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed(); //continue on the intercepted method
        log.info(method + " returns: " + result);
        return result;
    }

    public void logAfter(JoinPoint joinPoint) {
        log.info("logAfter() executes: " + joinPoint.getSignature().getName());
    }

    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        log.info("logAfterReturning() executes: " + method + "\t" + method + " returns: " + result);
    }

    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        String method = joinPoint.getSignature().getName();
        log.info("logAfterThrowing() executes: " + "\t" + method + " throws: " + error);
    }

}
