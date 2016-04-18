package com.linjun.java.springMvcWeb.webServer.bo;

/**
 * Created by linjun on 16/4/18.
 */
public class GetFromRedisRequest {
    public String key;

    public GetFromRedisRequest() {
    }

    public GetFromRedisRequest(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
