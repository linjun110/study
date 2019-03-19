package com.linjun.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config" +
                "/spring/linjun_ioc.xml");
        C c = (C) context.getBean("myc");
        c.say();
    }
}
