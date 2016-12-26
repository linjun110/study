package com.linjun.java.spring.model;

/**
 * Created by linjun on 17/1/16.
 */
public class Request {
    private String service;
    private String operation;
    private String request;

    public Request(String service, String operation, String request) {
        this.service = service;
        this.operation = operation;
        this.request = request;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
