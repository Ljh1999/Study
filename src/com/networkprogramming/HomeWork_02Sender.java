package com.networkprogramming;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议完成 发送端
 */
@SuppressWarnings({"ALL"})
public class HomeWork_02Sender {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(8889);

        byte[] bytes = "四大名著是哪些".getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.103"), 8888);
        datagramSocket.send(datagramPacket);

        byte[] bytes1 = new byte[1024];
        datagramPacket = new DatagramPacket(bytes1, bytes1.length);
        datagramSocket.receive(datagramPacket);
        int length = datagramPacket.getLength();
        byte[] data = datagramPacket.getData();

        String s = new String(data, 0, length);
        System.out.println(s);

        datagramSocket.close();
    }
}
