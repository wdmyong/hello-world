package com.wdm.reflect.proxy;

public class SecondClient {

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = HelloServiceProxyFactory.getHelloServiceProxy(helloService);
        System.out.println("proxy class name:\t" + proxy.getClass().getName());
        System.out.println(proxy.echo("ksks"));
        System.out.println(proxy.getTime());
    }
}
