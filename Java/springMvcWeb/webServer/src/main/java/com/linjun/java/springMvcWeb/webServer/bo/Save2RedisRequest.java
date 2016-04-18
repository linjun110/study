package com.linjun.java.springMvcWeb.webServer.bo;

/**
 * Created by linjun on 16/4/18.
 */
public class Save2RedisRequest {
    public String key;
    public String value;

    public Save2RedisRequest() {
    }

    public Save2RedisRequest(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
