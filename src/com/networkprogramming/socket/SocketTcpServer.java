package com.networkprogramming.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
@SuppressWarnings({"all"})
public class SocketTcpServer {
    public static void main(String[] args) throws IOException {
        //服务端在9999端口监听，等待连接
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端正在监听，等待连接...");
        //连接成功会返回一个socket
        Socket socket = serverSocket.accept();
        System.out.println(" 服务端 " + socket.getClass());

        //读取客户端写入到数据通道的数据
        InputStream inputStream = socket.getInputStream();
        //IO读取
        byte[] bytes = new byte[1024];
        int readLine = 0;
        while ((readLine = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readLine));
        }


        inputStream.close();
        serverSocket.close();
        socket.close();
    }
}
