package com.wdm.reflect.rmi;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Connector {

    private String host;
    private int port;
    private Socket socket;
    private InputStream inputStream;
    private ObjectInputStream objectInputStream;
    private OutputStream outputStream;
    private ObjectOutputStream objectOutputStream;

    public Connector(String host, int port) throws Exception {
        super();
        this.host = host;
        this.port = port;
        connect();
    }

    public void send(Object object) throws IOException {
        objectOutputStream.writeObject(object);
    }

    public Object receive() throws ClassNotFoundException, IOException {
        return objectInputStream.readObject();
    }

    public void connect() throws Exception {
        connect(host, port);
    }

    public void connect(String host, int port) throws Exception {
        socket = new Socket(host, port);
        outputStream = socket.getOutputStream();
        objectOutputStream = new ObjectOutputStream(outputStream);
        inputStream = socket.getInputStream();
        objectInputStream = new ObjectInputStream(inputStream);
    }

    public void close() {
        try {
        } finally {
            try {
                outputStream.close();
                inputStream.close();
                socket.close();
            } catch (Exception e) {
                System.out.println("Connector close error:\t" + e);
            }
        }
    }
}
