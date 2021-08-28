package com.networkprogramming;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
@SuppressWarnings({"all"})
public class HomeWork_01Server {
    public static void main(String[] args) throws IOException {
        //在9999等待被连接
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String s = bufferedReader.readLine();
        String answer;
        if (s.equals("name")) {
            answer = "Ljh";
        } else if (s.equals("hobby")) {
            answer = "编写java程序";
        } else {
            answer = "你说的啥";
        }
        bufferedWriter.write(answer);
        bufferedWriter.newLine();
        bufferedWriter.flush();
        System.out.println(s);

        bufferedWriter.close();
        bufferedReader.close();
        serverSocket.close();
        socket.close();
    }
}
