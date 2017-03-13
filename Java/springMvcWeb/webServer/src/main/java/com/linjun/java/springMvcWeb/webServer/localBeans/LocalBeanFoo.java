package com.linjun.java.springMvcWeb.webServer.localBeans;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by linjun on 17/3/17.
 */
public class LocalBeanFoo {
    private static Logger logger = LogManager.getLogger(LocalBeanFoo.class);
    public LocalBeanFoo(){
        logger.info("Local Bean Foo created");
    }

    public void say(){
        logger.info("Local Bean Foo say hi");
    }
}
