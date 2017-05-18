package com.wdm.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class HelloServiceProxyFactory {

    public static HelloService getHelloServiceProxy(final HelloService helloServiceImpl) throws Exception {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("before calling:\t" + method);
                Object result = method.invoke(helloServiceImpl, args);
                System.out.println("after calling:\t" + method);
                return result;
            }
        };
        Class<?> proxyClass = Proxy.getProxyClass(HelloService.class.getClassLoader(), 
                new Class<?>[]{HelloService.class});
        HelloService helloService = (HelloService) proxyClass.getConstructor(
                new Class<?>[]{InvocationHandler.class}).newInstance(new Object[]{handler});
        helloService = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(), 
                new Class<?>[]{HelloService.class}, handler);
        return helloService;
    }
}
