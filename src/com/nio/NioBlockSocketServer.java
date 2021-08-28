package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 阻塞式NIO完成网络通讯   //服务端
 */
@SuppressWarnings({"all"})
public class NioBlockSocketServer {
    public static void main(String[] args) {
        ServerSocketChannel open = null;
        SocketChannel socketChannel = null;
        FileChannel fileChannel = null;
        try {
            open = ServerSocketChannel.open();
            fileChannel = FileChannel.open(Paths.get("e:\\2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
            //绑定连接
            open.bind(new InetSocketAddress(9898));

            socketChannel = open.accept();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (socketChannel.read(buffer) != -1) {
                buffer.flip();
                fileChannel.write(buffer);
                buffer.clear();
            }

            //返回提示信息给客户端
            buffer.put("服务端成功接受数据！".getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();

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
            if (socketChannel != null) {
                try {
                    socketChannel.close();
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
