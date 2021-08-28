package com.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * 非阻塞式NIO完成网络通讯 UDP
 */
public class NioDatagramSend {
    public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open();
        datagramChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            buffer.put((LocalDateTime.now() + "\n" + s).getBytes());
            buffer.flip();
            datagramChannel.send(buffer, new InetSocketAddress("127.0.0.1", 9898));
            buffer.clear();
        }
        datagramChannel.close();
    }
}
