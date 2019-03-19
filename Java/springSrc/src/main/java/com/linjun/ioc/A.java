package com.linjun.ioc;

public class A {
    private B b;
    private String name;

    public void say() {
        System.out.println("A: " + name + " with B:" + b.getName());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
