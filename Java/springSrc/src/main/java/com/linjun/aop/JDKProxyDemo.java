package com.linjun.aop;

import java.lang.reflect.Proxy;

public class JDKProxyDemo {
    public static void main(String[] args) {
        ICanEat p = (ICanEat) Proxy.newProxyInstance(JDKProxyDemo.class.getClassLoader(),
                new Class<?>[]{ICanEat.class}, new InvocationHandlerTest(new Eater()));
        p.eat();
    }
}
