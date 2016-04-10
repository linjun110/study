package com.linjun.java.springMvcWeb.bo;

/**
 * Created by linjun on 16/4/9.
 */
public class Employee {
    private String id;
    private String name;
    private String password;
    private String idCard;

    private Integer gender;
    private Long birthday;
    private String role;

    private Integer enabled;

    public Employee() {
    }
    public Employee(String name, String password, String idCard, Integer gender, Long birthday, String role, Integer enabled) {
        this.name = name;
        this.password = password;
        this.idCard = idCard;
        this.gender = gender;
        this.birthday = birthday;
        this.role = role;
        this.enabled = enabled;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
