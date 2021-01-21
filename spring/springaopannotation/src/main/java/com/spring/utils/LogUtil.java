package com.spring.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LogUtil {
    @Pointcut("execution(* com.spring.service..*.*(..))")
    public void pointcut() {}

    @Before("pointcut()")
    public void beforePrintLog(JoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        System.out.println("前置通知beforePrintLog=" + Arrays.toString(args));
    }

    @AfterReturning(value = "pointcut()",  returning = "rtValue")
    public void afterReturnPrintLog(JoinPoint joinPoint, Object rtValue) throws Throwable {
        System.out.println("后置通知afterReturnPrintLog=" + rtValue);
    }

    @AfterThrowing(value = "pointcut()", throwing = "t")
    public void afterThrowingPrintLog(JoinPoint joinPoint, Throwable t) throws Throwable {
        t.printStackTrace();
        System.out.println("异常通知afterThrowingPrintLog");
    }

    @After("pointcut()")
    public void afterPrintLog(JoinPoint joinPoint) throws Throwable {
        System.out.println("最终通知afterPrintLog");
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            this.beforePrintLog(joinPoint);

            Object[] args = joinPoint.getArgs();
            Object obj = joinPoint.proceed(args);

            this.afterReturnPrintLog(joinPoint, obj);
            return obj;
        } catch (Throwable t) {
            t.printStackTrace();
            this.afterThrowingPrintLog(joinPoint, t);
        } finally {
            this.afterPrintLog(joinPoint);
        }
        return null;
    }
}
