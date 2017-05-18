package com.wdm.reflect.rmi;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleServer {

    private Map<String, Object> remoteObjMap = new ConcurrentHashMap<>();

    public void register(String className, Object object) {
        remoteObjMap.put(className, object);
    }

    @SuppressWarnings("resource")
    public void service() throws Exception {
        ServerSocket serverSocket = new ServerSocket(9080);
        System.out.println("server start...");
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            Call call = (Call) objectInputStream.readObject();
            System.out.println(call);
            call = invoke(call);
            objectOutputStream.writeObject(call);
            objectInputStream.close();
            objectOutputStream.close();
            socket.close();
        }
    }

    public Call invoke(Call call) {
        Object result = null;
        try {
            String className = call.getClassName();
            String methodName = call.getMethodName();
            Class<?>[] paramsTypes = call.getParamTypes();
            Object[] params = call.getParams();
            Class<?> classType = Class.forName(className);
            Method method = classType.getMethod(methodName, paramsTypes);
            Object remoteObj = remoteObjMap.get(className);
            if (remoteObj == null) {
                throw new Exception(className + "has not remote instance");
            } else {
                result = method.invoke(remoteObj, params);
            }
        } catch (Exception e) {
            result = e;
        }
        call.setResult(result);
        return call;
    }

    public static void main(String[] args) throws Exception {
        SimpleServer server = new SimpleServer();
        server.register("com.wdm.reflect.rmi.HelloService", new HelloServiceImpl());
        server.service();
    }
}
