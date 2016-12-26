package com.linjun.java.spring;

import com.linjun.java.spring.handler.Dispatcher;
import com.linjun.java.spring.model.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("./configuration/beans.xml");

        Dispatcher dispatcher = (Dispatcher)context.getBean(Dispatcher.BEAN_NAME);
        Request p = new Request("ShippingConfigPlatformService", "Compile", "{\"name\":\"100+3*24\"}");
        String output = dispatcher.dispatch(p);
        System.out.println(output);
    }
}
