package com.wdm.aop;

import org.springframework.aop.framework.ProxyFactory;

public class Main {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        Pojo pojo = new SimplePojo();
        pojo.foo();
    }

    public static void test2() {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        //factory.addAdvice(new RetryAdvice());

        Pojo pojo1 = (Pojo) factory.getProxy();

        // this is a method call on the proxy!
        pojo1.foo();
    }

    public static void test3() {
        ProxyFactory factory = new ProxyFactory(new SimplePojo2());
        factory.addInterface(Pojo.class);
        //factory.addAdvice(new RetryAdvice());
        factory.setExposeProxy(true);

        Pojo pojo = (Pojo) factory.getProxy();

        // this is a method call on the proxy!
        pojo.foo();
    }
}
