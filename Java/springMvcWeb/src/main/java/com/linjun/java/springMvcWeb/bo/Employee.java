package com.linjun.java.springMvcWeb.bo;

import com.linjun.java.springMvcWeb.utils.CommonUtil;

/**
 * Created by linjun on 16/4/9.
 */
public class Employee {
    private String uuid;
    private String name;
    private String password;
    private String idCard;
    private Integer gender;
    private Long birthday;

    public Employee() {
    }
    public Employee(String name, String password, String idCard, Integer gender, Long birthday) {
        this.name = name;
        this.password = password;
        this.idCard = idCard;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }
}
