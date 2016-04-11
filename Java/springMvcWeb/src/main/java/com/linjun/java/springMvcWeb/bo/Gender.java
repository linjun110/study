package com.linjun.java.springMvcWeb.bo;

/**
 * Created by linjun on 16/4/11.
 */
public enum Gender {
    MALE(0),
    FELMALE(1);

    private int value;
    Gender(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
