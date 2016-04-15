package com.linjun.java.springMvcWeb.webServer.bo;

/**
 * Created by linjun on 16/4/11.
 */
public class JsonResult {
    private String status;
    private String msg;

    public JsonResult() {
    }
    public JsonResult(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
