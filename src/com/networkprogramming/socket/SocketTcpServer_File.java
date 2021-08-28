package com.networkprogramming.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
@SuppressWarnings({"all"})
public class SocketTcpServer_File {
    public static void main(String[] args) throws IOException {
//        服务端在本机监听8888端口
        ServerSocket serverSocket = new ServerSocket(8888);
//        等待连接
        Socket socket = serverSocket.accept();

//        读取客户端数据通道的数据
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = null;
        byte[] bytes = new byte[1024];
        int read = 0;
        //把从数据通道读到的数据写入byteArrayOutputStream
        while ((read = bufferedInputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, read);
        }
        //把byteArrayOutputStream 转成字节数组array
        byte[] array = byteArrayOutputStream.toByteArray();
        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:\\IntelliJ IDEA 2018.3.3\\work\\Study\\src\\动漫单车美女.jpg"));
        bufferedOutputStream.write(array);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("收到图片");
        bufferedWriter.flush();  //把内容刷新到通道
        socket.shutdownOutput();        //结束标记

        bufferedWriter.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        byteArrayOutputStream.close();
        serverSocket.close();
        socket.close();
    }
}
