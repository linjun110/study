package com.linjun.language.java;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by linjun on 16/4/28.
 */
public class AnyThing {
    public static void main( String[] args ){
        A a = new AnyThing.A();
        B b = new AnyThing.B();
        func(b);
    }

    public static void func(Object o){
        try{
            Class clazz = o.getClass();
            Method m = clazz.getDeclaredMethod("sayHi");
            if(!AnyThing.A.class.isInstance(o)){
                System.out.println("not a");
                return;
            }
            m.invoke(o);
        }catch(NoSuchMethodException e1){
            System.out.println("no such method");
        }catch(IllegalAccessException e2){
            System.out.println("illegal access");
        }catch(IllegalArgumentException e3){
            System.out.println("illegal argument");
        }catch(InvocationTargetException e4){
            System.out.println("illegal target");
        }
    }

    static class A{
        public void sayHi(){
            System.out.println("hi I am a");
        }

    }
    static class B{
        public void sayHi(){
            System.out.println("hi I am b");
        }

    }
}
