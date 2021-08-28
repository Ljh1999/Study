package com.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 非阻塞式NIO完成网络通讯    //客户端
 */
@SuppressWarnings({"all"})
public class NioNoBlockSocketClient {
    public static void main(String[] args) {
        SocketChannel socketChannel = null;

        try {
            //获取通道
            socketChannel = SocketChannel.open(new InetSocketAddress(InetAddress.getLocalHost(), 9999));
            //切换成非阻塞模式
            socketChannel.configureBlocking(false);
            //分配指定大小的缓冲区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            //放入数据到缓冲区
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String s = scanner.next();
                byteBuffer.put((LocalDateTime.now().toString() + "\n" + s).getBytes());
                //切换到读取数据模式
                byteBuffer.flip();
                //将数据写入通道
                socketChannel.write(byteBuffer);
                byteBuffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //关闭通道
                if(socketChannel != null){
                socketChannel.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

