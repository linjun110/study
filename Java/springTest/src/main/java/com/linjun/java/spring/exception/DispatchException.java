package com.linjun.java.spring.exception;

/**
 * Created by linjun on 17/1/16.
 */
public class DispatchException extends Exception{
    private String msg;

    public DispatchException(Throwable cause){
        super(cause);
    }
    public DispatchException(String msg){
        super(msg);
    }
}
