package com.linjun;

import com.linjun.beans.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config" +
                "/spring/linjun_aop.xml");
        Person p = (Person) context.getBean("myperson");
        System.out.println(p.getName());
    }
}
