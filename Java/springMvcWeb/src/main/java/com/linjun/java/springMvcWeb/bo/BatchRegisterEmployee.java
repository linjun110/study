package com.linjun.java.springMvcWeb.bo;

/**
 * Created by linjun on 16/4/9.
 */
public class BatchRegisterEmployee {
    private String name;
    private String password;
    private String idCard;

    public BatchRegisterEmployee() {
    }
    public BatchRegisterEmployee(String name, String password, String idCard){
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

    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
