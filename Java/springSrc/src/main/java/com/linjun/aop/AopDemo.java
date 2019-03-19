package com.linjun.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config" +
                "/spring/linjun_aop.xml");
        ICanEat eater = (ICanEat) context.getBean("myeater");
        eater.eat();
    }
}
