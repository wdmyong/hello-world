package com.wdm.reflect.proxy;

import java.util.Date;

public class HelloServiceProxy implements HelloService {

    private HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    public HelloService getHelloService() {
        return helloService;
    }

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String echo(String msg) {
        System.out.println("before call echo");
        String result = helloService.echo(msg);
        System.out.println("after call echo");
        return result;
    }

    @Override
    public Date getTime() {
        System.out.println("before call getTime");
        Date date = helloService.getTime();
        System.out.println("after call getTime");
        return date;
    }
}
