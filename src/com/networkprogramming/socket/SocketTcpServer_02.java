package com.networkprogramming.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class SocketTcpServer_02 {
    public static void main(String[] args) throws IOException {
        //在9999端口等待连接
        ServerSocket serverSocket = new ServerSocket(9998);
        //连接成功返回socket对象
        Socket socket = serverSocket.accept();


        //读取数据通道信息
        InputStream inputStream = socket.getInputStream();
        int readLine = 0;
        byte[] bytes = new byte[1024];
        while ((readLine = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLine));
        }
        //往数据通道写入数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,Client".getBytes());
        socket.shutdownOutput();

        inputStream.close();
        outputStream.close();
        serverSocket.close();
        socket.close();
    }
}
