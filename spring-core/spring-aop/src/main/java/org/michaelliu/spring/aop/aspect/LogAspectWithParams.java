package org.michaelliu.spring.aop.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.michaelliu.spring.beans.SimpleAccount;

/**
 * Created by michael on 2016/7/31.
 */
@Aspect
public class LogAspectWithParams {

    private static Log log = LogFactory.getLog(LogAspectWithParams.class);

    @Pointcut("execution(* org.michaelliu.spring.aop.service.AccountService.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void before1(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        log.info("before1 receives params: " + args);
        log.info(joinPoint.getTarget());
        log.info(joinPoint.getThis());
        log.info(joinPoint.getSignature());
    }

    @Before("execution(* org.michaelliu.spring.aop.service.AccountService.*(..)) && args(account, amount)")
    public void before2(SimpleAccount account, Integer amount) {
        log.info("before2 receives params: " + account + ", " + amount);
    }

    @Around("execution(* org.michaelliu.spring.aop.service.AccountService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        log.info("around receives: " + args);
        String method = joinPoint.getSignature().getName();
        SimpleAccount account = (SimpleAccount) args[0];
        if (method.equals("drawMoney") && account.getBalance() <= 0) {
            log.info("No money available to draw out of account!");
            throw new IllegalStateException("No money in the account!");
        }
        Object result = joinPoint.proceed();
        log.info(method + " returns: " + result);
        return result;
    }

    @AfterReturning(
            pointcut = "execution(* org.michaelliu.spring.aop.service.AccountService.*(..))",
            returning= "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().getName();
        log.info("afterReturning() executes: " + method + "\t" + method + " returns: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* org.michaelliu.spring.aop.service.AccountService.*(..))",
            throwing= "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        String method = joinPoint.getSignature().getName();
        log.info("afterReturning() executes: " + "\t" + method + " throws: " + error);
    }

}
