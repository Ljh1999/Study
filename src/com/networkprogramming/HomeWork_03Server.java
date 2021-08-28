package com.networkprogramming;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
@SuppressWarnings({"All"})
public class HomeWork_03Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = null;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println(s);

        String path = "e:\\" + s;
        File file = new File(path);
        BufferedInputStream bufferedInputStream = null;
        if(file.exists()){
            bufferedInputStream= new BufferedInputStream(new FileInputStream(path));
            System.out.println("文件存在，返回该" + path + "文件" );
            int redLine = 0;
            byte[] bytes = new byte[1024];
            while ((redLine = bufferedInputStream.read(bytes)) != -1) {
                byteArrayOutputStream.write(bytes,0,redLine);
            }
            byte[] MusicData = byteArrayOutputStream.toByteArray();
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            bufferedOutputStream.write(MusicData);
            bufferedOutputStream.flush();
            socket.shutdownOutput();

        }else {
            String defaultfilepath = "d:\\忘了没有 - 王靖雯不胖.mp3";
            bufferedInputStream = new BufferedInputStream(new FileInputStream(defaultfilepath));
            System.out.println("文件不存在，返回默认文件" + defaultfilepath);
            int redfile = 0;
            byte[] byte1 = new byte[1024];
            while ((redfile = bufferedInputStream.read(byte1)) != -1) {
                byteArrayOutputStream.write(byte1,0,redfile);
            }

            byte[] defaultfiledata = byteArrayOutputStream.toByteArray();
            bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
            bufferedOutputStream.write(defaultfiledata);
            bufferedOutputStream.flush();
            socket.shutdownOutput();
        }

        bufferedInputStream.close();
        bufferedReader.close();
        byteArrayOutputStream.close();
        bufferedOutputStream.close();
        serverSocket.close();
        socket.close();
    }
}
