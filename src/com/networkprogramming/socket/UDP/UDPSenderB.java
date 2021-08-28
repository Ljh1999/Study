package com.networkprogramming.socket.UDP;


import java.io.IOException;
import java.net.*;

/**
 * 发送端B
 */
@SuppressWarnings({"all"})
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //创建DatagramSocket对象，用于在9998端口发送和接受数据包
        DatagramSocket datagramSocket = new DatagramSocket(9998);
        //将需要发送的数据，封装到DatagramPacket对象
        byte[] bytes = "hello,明天打LOL".getBytes();  //封装的DatagramPacket对象的内容字节数组
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, InetAddress.getByName("192.168.1.103"), 9999); //内容字节数组，长度，目的ip地址，端口
        //调用发送方法
        datagramSocket.send(datagramPacket);

        //定义一个字节数组，用于接受数据包
        byte[] date = new byte[1024];
        //将数据封装到DatagramPacket对象，装包
        datagramPacket = new DatagramPacket(date, date.length);
        //调用接受数据包方法，会一直在9999端口等待，当有数据包发送到9999端口，就会接收数据，没有接受到数据包一直处于阻塞状态
        datagramSocket.receive(datagramPacket);
        //将datagramPacket进行拆包，取出数据，并打印
        int length = datagramPacket.getLength();//实际接收到数据的长度
        bytes = datagramPacket.getData();//将接受到的数据放入字节数组
        System.out.println(new String(bytes, 0, length));//打印数据

        datagramSocket.close();//关闭连接。释放资源
    }
}
