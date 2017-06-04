package com.wdm.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceDynmicProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object object) {
        target = object;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
                target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("I am JDK dynmic proxy !");
        System.out.println("before call real implements");
        Object result = method.invoke(target, args);
        System.out.println("after call real implements");
        return result;
    }
}
