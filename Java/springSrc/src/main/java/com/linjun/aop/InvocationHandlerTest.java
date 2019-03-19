package com.linjun.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InvocationHandlerTest implements InvocationHandler {

    ICanEat eater;

    public InvocationHandlerTest(ICanEat eater) {
        this.eater = eater;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before eat");

        method.invoke(eater, args);

        System.out.println("After eat");

        return null;
    }
}
