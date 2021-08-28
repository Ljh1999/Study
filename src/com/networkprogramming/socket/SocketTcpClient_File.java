package com.networkprogramming.socket;



import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 */
@SuppressWarnings({"all"})
public class SocketTcpClient_File {
    public static void main(String[] args) throws IOException {
        //连接服务端8888端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建字节输入流，读取图片文件
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("e:\\图片\\wallhaven-y85v2x.jpg"));
        BufferedOutputStream bufferedOutputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[1024];  //字节数组
        int read = 0;
        //边读边写
        while ((read = bufferedInputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, read);
        }
        //byteArrayOutputStream转成字节数组,array就是图片文件对应的字节数组
        byte[] array = byteArrayOutputStream.toByteArray();
        //然后把array写入数据通道
        OutputStream outputStream = socket.getOutputStream();
        bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(array);
        //设置写入数据的结束标记
        socket.shutdownOutput();


        //读取数据通道的数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
        bufferedInputStream.close();
        bufferedOutputStream.close();
        byteArrayOutputStream.close();
        socket.close();
    }
}
