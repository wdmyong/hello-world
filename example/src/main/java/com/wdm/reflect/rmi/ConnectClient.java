package com.wdm.reflect.rmi;

public class ConnectClient {

    public static void main(String[] args) throws Exception {
        HelloService firstService = new HelloServiceConnectProxy("127.0.0.1", 9080);
        System.out.println(firstService.echo("connect static proxy"));
        System.out.println(firstService.getTime());

        HelloService secondService = (HelloService) ConnectProxyFactory.getProxy(
                HelloService.class, "127.0.0.1", 9080);
        System.out.println(secondService.echo("connect dynamic proxy"));
        System.out.println(secondService.getTime());
    }
}
