package jvm;

/**
 * Created by linjun on 16/9/19.
 */
public class B extends A {
    public void func(T t){
        System.out.println("BT:" + t.getVar());
    }
    public void func(U t){
        System.out.println("BU:" + t.getVar());
    }
}
