package com.wdm.aop;

public class SimplePojo implements Pojo {

    @Override
    public void foo() {
        // this next method invocation is a direct call on the 'this' reference
        this.bar();
    }

    @Override
    public void bar() {
        // some logic...
        System.out.println("nothing");
    }
}
