package com.linjun.java.springMvcWeb.webServer.aspects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by linjun on 17/3/17.
 * TODO: research on Aspect
 */
@Aspect
public class FooAspect {
    private static Logger logger = LogManager.getLogger(FooAspect.class);
    public FooAspect(){
        logger.info("Foo Aspect created");
    }
    @Before("execution(* com.linjun.java.springMvcWeb.webServer.controller.MyController.*())")
    public void before(){
        logger.info("before");
    }
    @After("execution(* com.linjun.java.springMvcWeb.webServer.controller.MyController.*())")
    public void after(){
        logger.info("after");
    }
}
