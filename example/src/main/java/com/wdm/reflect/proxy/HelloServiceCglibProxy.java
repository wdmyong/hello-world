package com.wdm.reflect.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class HelloServiceCglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object object) {
        target = object;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method arg1, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("I am cglib dynmic proxy !");
        System.out.println("before call real implements");
        Object result = proxy.invokeSuper(obj, args);
        System.out.println("after call real implements");
        return result;
    }

}
