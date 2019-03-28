package com.linjun.java.spring;

import com.linjun.java.spring.handler.Dispatcher;
import com.linjun.java.spring.model.Request;
import com.linjun.java.spring.toAspect.TestAspectTarget;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Try create coral service.
 */
public class AoPTestApp {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("./configuration/beans.xml");

        TestAspectTarget tat = (TestAspectTarget)context.getBean("aspectTarget");

        System.out.println(tat.test());
    }
}
