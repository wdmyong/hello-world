package com.wdm.reflect.proxy;

/*
 * @author wdmyong
 */
public class FirstClient {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy proxy = new HelloServiceProxy(helloService);
        System.out.println(proxy.echo("ksks"));
        System.out.println(proxy.getTime());
    }
}
