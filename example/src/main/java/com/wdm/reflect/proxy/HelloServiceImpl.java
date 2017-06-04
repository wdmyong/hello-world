package com.wdm.reflect.proxy;

import java.util.Date;

public class HelloServiceImpl implements HelloService {

    @Override
    public String echo(String msg) {
        System.out.println("implements output:\t" + msg);
        return "echo:\t" + msg;
    }

    @Override
    public Date getTime() {
        Date now = new Date();
        System.out.println("implements output:\t" + now);
        return now;
    }

}
