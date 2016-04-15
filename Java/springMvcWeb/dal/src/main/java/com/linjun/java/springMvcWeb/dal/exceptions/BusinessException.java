package com.linjun.java.springMvcWeb.dal.exceptions;

/**
 * Created by linjun on 16/4/7.
 */
public class BusinessException extends Exception {
    private Throwable cause;
    private String module;
    private int level;
    private String msg;

    public BusinessException(Throwable cause, String module, int level, String msg) {
        this.cause = cause;
        this.module = module;
        this.level = level;
        this.msg = msg;
    }
}
