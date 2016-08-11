package org.michaelliu.demo.spring.aop.aspect;

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
 *
 * This is an unordered execution, meaning that @Before can be invoked after @Around,
 * that @After can be invoked before @Around, because there exists overlaps between
 * methods.
 */
@Aspect
public class LogAspectAnnotation {

    private static Log log = LogFactory.getLog(LogAspectAnnotation.class);

    // scan all methods within AccountService
    @Before("execution(* org.michaelliu.demo.spring.aop.service.AccountService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        log.info("logBefore() executes: " + joinPoint.getSignature().getName());
    }

    // scan all methods within AccountService
    // return type should be Object, if it is void, logAfterReturning() cannot get any result value.
    @Around("execution(* org.michaelliu.demo.spring.aop.service.AccountService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String method = joinPoint.getSignature().getName();
        log.info("logAround() executes: " + method);
        log.info(method + " arguments: " + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed(); //continue on the intercepted method
        log.info(method + " returns: " + result);
        return result;
    }

    // scan all methods within AccountService
    @After("execution(* org.michaelliu.demo.spring.aop.service.AccountService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        log.info("logAfter() executes: " + joinPoint.getSignature().getName());
    }

    // scan all methods within AccountService
    @AfterReturning(
            pointcut = "execution(* org.michaelliu.demo.spring.aop.service.AccountService.*(..))",
            returning= "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        log.info("logAfterReturning() executes: " + method + "\t" + method + " returns: " + result);
    }

    // scan all methods within AccountService
    @AfterThrowing(
            pointcut = "execution(* org.michaelliu.demo.spring.aop.service.AccountService.*(..))",
            throwing= "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        String method = joinPoint.getSignature().getName();
        log.info("logAfterThrowing() executes: " + "\t" + method + " throws: " + error);
    }

}
