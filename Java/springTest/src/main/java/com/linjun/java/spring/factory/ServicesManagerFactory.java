package com.linjun.java.spring.factory;

import com.linjun.java.spring.annotation.Service;
import com.linjun.java.spring.handler.ServicesManager;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by linjun on 17/1/16.
 */
public class ServicesManagerFactory {
    private final static String SCAN_NAME_SPACE = "com.linjun.java.spring";


    private ServicesManager servicesManager;

    private Map<String, Object> scan(){
        ClassPathScanningCandidateComponentProvider provider
                = new ClassPathScanningCandidateComponentProvider(false);
        provider.addIncludeFilter(new AnnotationTypeFilter(Service.class));

        Map<String, Object> m = new HashMap<String, Object>();

        Set<BeanDefinition> beanDefs = provider.findCandidateComponents(SCAN_NAME_SPACE);
        for(BeanDefinition beanDef : beanDefs){
            try {
                Class<?> cl = Class.forName(beanDef.getBeanClassName());
                try {
                    m.put(cl.getAnnotation(Service.class).value(), cl.newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return m;

    }
    private ServicesManager create(){
        ServicesManager servicesManager = new ServicesManager();
        Map<String, Object> m = scan();
        servicesManager.setMap(m);
        return servicesManager;

    }
    synchronized public ServicesManager acquire(){
        if(null == servicesManager){
            servicesManager = create();
        }
        return servicesManager;
    }
}
