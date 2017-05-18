package com.wdm.reflect.rmi;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleClient {

    public void invoke(Call call) throws Exception {
        Socket socket = new Socket("127.0.0.1", 9080);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        objectOutputStream.writeObject(call);
        Call resultCall = (Call) objectInputStream.readObject();
        System.out.println(resultCall.getResult());
        objectInputStream.close();
        objectOutputStream.close();
        socket.close();
    }

    public static void main(String[] args) throws Exception {
        SimpleClient simpleClient = new SimpleClient();
        Call callTime = new Call("com.wdm.reflect.rmi.HelloService", "getTime", new Class<?>[]{}, 
                new Object[]{});
        Call callEcho = new Call("com.wdm.reflect.rmi.HelloService", "echo", new Class<?>[]{String.class}, 
                new Object[]{"yong"});
        simpleClient.invoke(callTime);
        simpleClient.invoke(callEcho);
    }
}
