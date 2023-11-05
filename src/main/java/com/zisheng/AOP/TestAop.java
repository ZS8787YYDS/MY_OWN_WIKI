package com.zisheng.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAop {
    private static final Logger log = LoggerFactory.getLogger(TestAop.class);
    @Pointcut("execution(* com.zisheng.Controller.*.*(..))")
    public void exp(){}
    @Around("exp()")
    public Object recordTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("Around方法执行了！！！");
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        log.info("目标类名：{}",className);
        log.info("目标方法名：{}",methodName);
        Long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        log.info(methodName + "方法执行了" + (endTime - startTime) / 1000.0 + "s");
        return result;
    }
}
