package com.linjun.aop;

public class Eater implements ICanEat {
    @Override
    public void eat() {
        System.out.println("I'm eating");
    }
}
