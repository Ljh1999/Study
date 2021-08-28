package com.networkprogramming.socket.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 接受端A
 */
@SuppressWarnings({"all"})
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象，用于在9999端口发送和接受数据包
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        //定义一个字节数组，用于接受数据包
        //将数据封装到DatagramPacket对象，装包
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        //调用接受数据包方法，会一直在9999端口等待，当有数据包发送到9999端口，就会接收数据，没有接受到数据包一直处于阻塞状态
        datagramSocket.receive(datagramPacket);

        //将datagramPacket进行拆包，取出数据，并打印
        int length = datagramPacket.getLength();//实际接收到数据的长度
        byte[] data = datagramPacket.getData();//将接受到的数据放入字节数组
        System.out.println(new String(data, 0, length));  //打印数据

        //将发送的数据放入字节数组
        bytes = "好，明天见".getBytes();
        //封装到datagramPacket对象，并指定目的ip，和端口
        datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.103"), 9998);
        //调用发生方法
        datagramSocket.send(datagramPacket);


        datagramSocket.close(); //关闭连接。释放资源
    }
}
