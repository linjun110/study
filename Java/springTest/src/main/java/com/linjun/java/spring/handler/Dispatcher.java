package com.linjun.java.spring.handler;

import com.linjun.java.spring.exception.DispatchException;
import com.linjun.java.spring.model.Applier;
import com.linjun.java.spring.model.Request;

public class Dispatcher {
    public static final String BEAN_NAME = "dispatcher";

    private ServicesManager servicesManager;

    public Dispatcher(ServicesManager servicesManager){
        this.servicesManager = servicesManager;
    }

    public String dispatch(Request request){
        try {
            Applier applier = servicesManager.getApplier(request.getService(), request.getOperation());
            return applier.apply(request.getRequest());
        } catch (DispatchException e) {
            e.printStackTrace();
        }
        return null;
    }
}
