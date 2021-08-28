package com.networkprogramming;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议完成 接受端
 */
@SuppressWarnings({"ALL"})
public class HoneWork_02Receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();
        String s = new String(data, 0, length);
        System.out.println(s);


        byte[] date = null;
        if("四大名著是哪些".equals(s)){
            date = "四大名著是红楼梦,水浒传,西游记,三国演义".getBytes();
        }else {
            date = "what?".getBytes();
        }
        datagramPacket = new DatagramPacket(date, date.length, InetAddress.getByName("192.168.1.103"), 8889);
        datagramSocket.send(datagramPacket);

        datagramSocket.close();
    }
}
