package com.linjun.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
    public void myBefore() {
        System.out.println("my before");
    }

    public void myAfterReturning(Object rtVal) {
        System.out.println("my after returning");
    }

    public void myAfterThrowning(Exception e) {
        System.out.println("my after throwning");
    }

    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before my around");
        Object o = joinPoint.proceed();
        System.out.println("after my around");
        return o;
    }

    public void myAfter() {
        System.out.println("my after");
    }
}
