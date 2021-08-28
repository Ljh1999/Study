package com.networkprogramming.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端，发送一个hello，server
 */
@SuppressWarnings({"all"})
public class SocketTcpClient {
    public static void main(String[] args) throws IOException {
        // 连接服务端（ip，端口）
        // 连接本机的9999端口，如果连接成功，返回一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println(" 客户端 " + socket.getClass());

        //通过输出流写入数据到数据通道
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,Server".getBytes());

        //关闭流对象和socket
        outputStream.close();
        socket.close();
        System.out.println("客户端退出...");
    }
}
