package com.wdm.reflect;

import java.lang.reflect.Method;

public class InvokeTester {

    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public String echo(String msg) {
        return "echo:\t" + msg;
    }

    public static void main(String[] args) throws Exception {
        Class<?> classType = InvokeTester.class;
        Object invokerTester = classType.getConstructor(new Class[]{}).newInstance();
        Method addMethod = classType.getMethod("add",  new Class[]{int.class, int.class});
        Object result = addMethod.invoke(invokerTester, new Object[]{90, new Integer(200)});
        System.out.println((Integer)result);
        Method echoMethod = classType.getMethod("echo", new Class[]{String.class});
        result = echoMethod.invoke(invokerTester, new Object[]{"Hello world"});
        System.out.println((String)result);
    }
}
