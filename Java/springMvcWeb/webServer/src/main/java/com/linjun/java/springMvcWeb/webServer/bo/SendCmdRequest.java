package com.linjun.java.springMvcWeb.webServer.bo;

/**
 * Created by linjun on 16/4/15.
 */
public class SendCmdRequest {
    private String cmd;

    public SendCmdRequest() {}
    public SendCmdRequest(String cmd) {
        this.cmd = cmd;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }
}
