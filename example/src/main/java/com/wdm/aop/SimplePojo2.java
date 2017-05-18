package com.wdm.aop;

import org.springframework.aop.framework.AopContext;

public class SimplePojo2 implements Pojo {

    @Override
    public void foo() {
        ((Pojo) AopContext.currentProxy()).bar();
    }

    @Override
    public void bar() {
        System.out.println("nothing2");
    }
}
