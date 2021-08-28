package com.networkprogramming.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
@SuppressWarnings({"all"})
public class SocketTcpClinet_02 {
    public static void main(String[] args) throws IOException {
        //连接本机的9998端口，如果连接成功，返回一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);

        //写入数据到数据通道
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,Server".getBytes());
        //设置结束标记
        socket.shutdownOutput();

        //读取数据通道数据
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int readServerLine = 0;
        while ((readServerLine = inputStream.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, readServerLine));
        }
        //关闭流
        outputStream.close();
        inputStream.close();
        socket.close();
    }
}
