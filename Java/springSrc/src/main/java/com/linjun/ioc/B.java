package com.linjun.ioc;

public class B {
    private A a;
    private String name;

    public void say() {
        System.out.println("B: " + name + " with A:" + a.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
