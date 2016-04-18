package com.linjun.java.springMvcWeb.webServer.bo;

/**
 * Created by linjun on 16/4/9.
 */
public class BatchRegisterEmployeeRequest {
    private String name;
    private String password;
    private Integer gender;
    private String idCard;

    public BatchRegisterEmployeeRequest() {
    }
    public BatchRegisterEmployeeRequest(String name, String password, String idCard){
        this.name = name;
        this.password = password;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
