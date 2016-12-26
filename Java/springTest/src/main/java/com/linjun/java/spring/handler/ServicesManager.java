package com.linjun.java.spring.handler;

import com.linjun.java.spring.annotation.Operation;
import com.linjun.java.spring.exception.DispatchException;
import com.linjun.java.spring.model.Applier;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Created by linjun on 17/1/16.
 */
public class ServicesManager {
    public static final String BEAN_NAME = "servicesManager";

    public static final String SERVICE_NOT_FOUND = "service not found";
    public static final String OPERATION_NOT_FOUND = "operation not found";
    public static final String CREATE_APPLIER_FAILED = "create applier failed";

    private Map<String, Object> service2Bean;


    public Applier getApplier(String service, String operation) throws DispatchException {
        Object clazz = getServiceObject(service);
        Method[] methods = clazz.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if(method.getDeclaredAnnotation(Operation.class).value().equals(operation)){
                try {
                    return new Applier(clazz, method);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new DispatchException(CREATE_APPLIER_FAILED);
                }
            }
        }
        throw new DispatchException(OPERATION_NOT_FOUND);
    }

    private Object getServiceObject(String service) throws DispatchException {
        if(null == service2Bean.get(service)){
            throw new DispatchException(SERVICE_NOT_FOUND);
        }
        return service2Bean.get(service);
    }

    public void setMap(Map<String, Object> map){
        this.service2Bean = map;
    }
}
