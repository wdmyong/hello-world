package com.wdm.reflect.rmi;

import java.util.Date;

import com.wdm.reflect.rmi.Call;

import javassist.tools.rmi.RemoteException;

public class HelloServiceConnectProxy implements HelloService {

    private String host;
    private int port;


    public HelloServiceConnectProxy(String host, int port) {
        super();
        this.host = host;
        this.port = port;
    }

    @Override
    public String echo(String msg) {
        Connector connector = null;
        try {
            connector = new Connector(host, port);
            Call call = new Call("com.wdm.reflect.rmi.HelloService", "echo", 
                    new Class<?>[]{String.class}, new Object[]{msg});
            connector.send(call);
            Call callResult = (Call)connector.receive();
            Object result = callResult.getResult();
            if (result instanceof Exception) {
                throw new RemoteException((Exception) result);
            } else {
                return (String) result;
            }
        } catch (Exception e) {
            throw new RemoteException(e);
        } finally {
            if (connector != null) {
                connector.close();
            }
        }
    }

    @Override
    public Date getTime() {
        Connector connector = null;
        try {
            connector = new Connector(host, port);
            Call call = new Call("com.wdm.reflect.rmi.HelloService", "getTime", 
                    new Class<?>[]{}, new Object[]{});
            connector.send(call);
            Call callResult = (Call)connector.receive();
            Object result = callResult.getResult();
            if (result instanceof Exception) {
                throw new RemoteException((Exception) result);
            } else {
                return (Date) result;
            }
        } catch (Exception e) {
            throw new RemoteException(e);
        } finally {
            if (connector != null) {
                connector.close();
            }
        }
    }
}
