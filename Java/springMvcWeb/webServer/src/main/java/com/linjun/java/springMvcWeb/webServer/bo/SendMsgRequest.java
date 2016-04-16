package com.linjun.java.springMvcWeb.webServer.bo;

/**
 * Created by linjun on 16/4/15.
 */
public class SendMsgRequest {
    private String msg;

    public SendMsgRequest() {}
    public SendMsgRequest(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
