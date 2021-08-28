package com.networkprogramming.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端 使用字符流方式读写
 */
@SuppressWarnings({"all"})
public class SocketTcpServer_03 {
    public static void main(String[] args) throws IOException {
        //在9999端口等待连接
        ServerSocket serverSocket = new ServerSocket(9998);
        //连接成功返回socket对象
        Socket socket = serverSocket.accept();

        //读取数据通道信息
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);

        //往数据通道写入数据
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello,Client 字符流");
        bufferedWriter.newLine();
        bufferedWriter.flush();

        //关闭外层流
        bufferedReader.close();
        bufferedWriter.close();
        serverSocket.close();
        socket.close();
    }
}
