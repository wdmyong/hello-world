package com.wdm.reflect.rmi;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.wdm.reflect.rmi.Call;

import javassist.tools.rmi.RemoteException;

public class ConnectProxyFactory {

    public static Object getProxy(final Class<?> classType, final String host, final int port) throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Connector connector = null;
                try {
                    connector = new Connector(host, port);
                    Call call = new Call(classType.getName(), method.getName(), 
                            method.getParameterTypes(), args);
                    connector.send(call);
                    Call callResult = (Call)connector.receive();
                    Object result = callResult.getResult();
                    if (result instanceof Exception) {
                        throw new RemoteException((Exception) result);
                    } else {
                        return result;
                    }
                } catch (Exception e) {
                    throw new RemoteException(e);
                } finally {
                    if (connector != null) {
                        connector.close();
                    }
                }
            }
        };
        Object proxy = Proxy.newProxyInstance(classType.getClassLoader(), 
                new Class<?>[]{classType}, handler);
        return proxy;
    }
}
