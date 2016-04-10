package com.linjun.java.springMvcWeb.bo;

/**
 * Created by linjun on 16/4/9.
 */
public class BatchEmployeeBO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    private String pw;
    private String idCard;


    public BatchEmployeeBO() {
    }
    public BatchEmployeeBO(String name, String pw, String idCard){
        this.name = name;
        this.pw = pw;
        this.idCard = idCard;
    }

}
