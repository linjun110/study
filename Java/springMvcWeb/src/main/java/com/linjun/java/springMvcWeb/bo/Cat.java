package com.linjun.java.springMvcWeb.bo;

/**
 * Created by linjun on 16/4/7.
 */
public class Cat {
    private int id;
    private String name;
    private long birthday;


    public Cat(){}
    public Cat(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }
}
