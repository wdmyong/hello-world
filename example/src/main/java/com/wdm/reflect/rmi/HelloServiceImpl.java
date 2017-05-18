package com.wdm.reflect.rmi;

import java.util.Date;

public class HelloServiceImpl implements HelloService {

    @Override
    public String echo(String msg) {
        return "echo:\t" + msg;
    }

    @Override
    public Date getTime() {
        return new Date();
    }

}
