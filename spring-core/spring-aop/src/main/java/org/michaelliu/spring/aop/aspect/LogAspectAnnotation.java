package org.michaelliu.spring.aop.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * Created by michael on 2016/7/31.
 */
@Aspect
public class LogAspectAnnotation {

    private static Log log = LogFactory.getLog(LogAspectAnnotation.class);

    // scan all methods within AccountService
    @Before("execution(* org.michaelliu.spring.aop.service.AccountService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("logBefore() executes: " + joinPoint.getSignature().getName());
    }

    // scan all methods within AccountService
    @Around("execution(* org.michaelliu.spring.aop.service.AccountService.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("logAround() executes: " + joinPoint.getSignature().getName());
        log.info("Method's arguments: " + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed(); //continue on the intercepted method
        log.info("Method's result : " + result);
    }

    // scan all methods within AccountService
    @After("execution(* org.michaelliu.spring.aop.service.AccountService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("logAfter() executes: " + joinPoint.getSignature().getName());
    }

    // scan all methods within AccountService
    @AfterReturning(
            pointcut = "execution(* org.michaelliu.spring.aop.service.AccountService.*(..))",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        log.info("logAfterReturning() executes: " + joinPoint.getSignature().getName());
        log.info("Method returns: " + result);
    }

    // scan all methods within AccountService
    @AfterThrowing(
            pointcut = "execution(* org.michaelliu.spring.aop.service.AccountService.*(..))",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.info("logAfterThrowing() executes: " + joinPoint.getSignature().getName());
        log.info("Method throws: " + error);
    }

}
