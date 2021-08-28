package com.networkprogramming;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
@SuppressWarnings({"ALL"})
public class HomeWork_03Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 7777);

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要下载的音乐名：");
        String next = scanner.next();
        bufferedWriter.write(next);
        bufferedWriter.newLine();
        bufferedWriter.flush();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int readline = 0;
        byte[] bytes = new byte[1024];
        while ((readline = bufferedInputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,readline);
        }
        byte[] filedata = byteArrayOutputStream.toByteArray();

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("e:\\我敢——胡彦斌.mp3"));
        bufferedOutputStream.write(filedata);

        bufferedInputStream.close();
        bufferedOutputStream.close();
        byteArrayOutputStream.close();
        bufferedWriter.close();
        socket.close();
    }
}
