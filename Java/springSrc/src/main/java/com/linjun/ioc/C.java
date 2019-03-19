package com.linjun.ioc;

import org.springframework.beans.factory.annotation.Autowired;

public class C {
    @Autowired
    private A a;
    private String name;

    public void say() {
        System.out.println("C: " + name + " with A:" + a.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
