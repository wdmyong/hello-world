package com.wdm.reflect.proxy;

public class ThirdClient {

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceDynmicProxy helloServiceDynmicProxy = new HelloServiceDynmicProxy();
        HelloService proxy = (HelloService) helloServiceDynmicProxy.bind(helloService);
        System.out.println("proxy class name:\t" + proxy.getClass().getName());
        System.out.println("return value:\t" + proxy.echo("ksks"));
        System.out.println("return value:\t" + proxy.getTime());
    }
}
