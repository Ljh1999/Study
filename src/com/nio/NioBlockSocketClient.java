package com.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 阻塞式NIO完成网络通讯    //客户端
 */
@SuppressWarnings({"all"})
public class NioBlockSocketClient {
    public static void main(String[] args) {
        SocketChannel open = null;
        FileChannel fileChannel = null;
        try {
            //获取socket通道
            open = SocketChannel.open(new InetSocketAddress(InetAddress.getLocalHost(), 9898));
            //获取文件通道
            fileChannel = FileChannel.open(Paths.get("e:\\1.txt"), StandardOpenOption.READ);
            //分配指定大小的缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(1024);

            while (fileChannel.read(allocate) != -1) {
                //切换到读数据模式
                allocate.flip();
                open.write(allocate);
                allocate.clear();
            }
            //此时如果不shutdown掉，会导致线程处于阻塞状态
            open.shutdownOutput();

            //读取服务器返回的信息
            int len = 0;
            while ((len = open.read(allocate)) != -1){
                allocate.flip();
                System.out.println(new String(allocate.array(),0,len));
                allocate.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

