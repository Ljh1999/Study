package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * 非阻塞式NIO完成网络通讯   //服务端
 */
@SuppressWarnings({"all"})
public class NioNoBlockSocketServer {
    public static void main(String[] args) {
        ServerSocketChannel serverSocketChannel = null;
        SocketChannel socketChannel = null;
        try {
            //获取通道
            serverSocketChannel = ServerSocketChannel.open();
            //切换非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //绑定连接
            serverSocketChannel.bind(new InetSocketAddress(9999));
            //获取选择器
            Selector selector = Selector.open();
            //将通道注册到选择器上,并且指定监听接受事件
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            //轮询的获取选择器上已经准备就绪的事件
            while (selector.select() > 0) {
                //获取当前选择器中所有注册的“选择键”（已就绪的监听事件）
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                //迭代获取准备就绪的事件
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    //判断具体是哪个事件准备就绪
                    if (key.isAcceptable()) {
                        //若“接受就绪”，就获取客户端连接
                        socketChannel = serverSocketChannel.accept();
                        //客户端连接也得是非阻塞式的
                        socketChannel.configureBlocking(false);
                        //将该通道也注册到选择器上，此时需要读取客户端发送的数据，则选择读事件
                        socketChannel.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {  //若读就绪
                        //获取选择器上读就绪状态的通道
                        socketChannel = (SocketChannel) key.channel();
                        //读取数据
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int len = 0;
                        while ((len = socketChannel.read(byteBuffer)) > 0) {
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(), 0, len));
                            byteBuffer.clear();
                        }
                    }
                    //取消选择键
                    iterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocketChannel != null) {
                try {
                    serverSocketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
