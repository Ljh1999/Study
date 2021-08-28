package com.networkprogramming.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端,使用字符流方式读写
 */
@SuppressWarnings({"all"})
public class SocketTcpClinet_03 {
    public static void main(String[] args) throws IOException {
        //连接本机的9998端口，如果连接成功，返回一个socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 9998);

        //写入数据到数据通道
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("Hello,Server 字符流");
        bufferedWriter.newLine(); //插入一个换行符，表示写入内容结束，注意：要求对方用readLine()的方式来读
        bufferedWriter.flush(); //手动刷新，否则内容不会写入通道

        //读取数据通道数据
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //关闭外层流
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
