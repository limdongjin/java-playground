package com.limdongjin.springexamplestudy.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// @Component 로 등록해서 사용할수도있음
@Aspect
public class TimeTraceAop {

    @Around("execution(* com.limdongjin.springexamplestudy.demo..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START"+ joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() +" "+timeMs +"ms");
        }
    }
}
