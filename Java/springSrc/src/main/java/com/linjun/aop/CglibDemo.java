package com.linjun.aop;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibDemo {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Eater.class);
        CallbackFilter callbackFilter = new CallbackFilter() {
            @Override
            public int accept(Method method) {
                if (method.getName().equals("eat")) {
                    return 0;
                }
                return 1;
            }
        };

        enhancer.setCallbackFilter(callbackFilter);

        Callback callback1 = new Dosomething();
        Callback noop = NoOp.INSTANCE;

        enhancer.setCallbacks(new Callback[]{callback1, noop});

        ICanEat eater = (ICanEat) enhancer.create();
        eater.eat();
    }
}

class Dosomething implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before execute " + method.getName());
        Object rt = methodProxy.invokeSuper(o, objects);
        System.out.println("After execute " + method.getName());
        return rt;
    }
}
