package com.wdm.reflect.proxy;

public class FourthClient {

    public static void main(String[] args) throws Exception {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceCglibProxy helloServiceCglibProxy = new HelloServiceCglibProxy();
        HelloService proxy = (HelloService) helloServiceCglibProxy.getInstance(helloService);
        System.out.println("proxy class name:\t" + proxy.getClass().getName());
        System.out.println("return value:\t" + proxy.echo("ksks"));
        System.out.println("return value:\t" + proxy.getTime());
    }
}
