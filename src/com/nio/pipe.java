package com.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 管道
 */

public class pipe {
    public static void main(String[] args) throws IOException {
         //获取管道
        Pipe pipe = Pipe.open();
        //将缓冲区的数据写入管道
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sink = pipe.sink();
        buffer.put("通过单向管道发送数据".getBytes());
        buffer.flip();
        sink.write(buffer);

        //读取缓冲区中的数据
        Pipe.SourceChannel source = pipe.source();
        buffer.flip();
        int read = source.read(buffer);
        System.out.println(new String(buffer.array(),0,read));
        buffer.clear();
        sink.close();
        source.close();
    }
}
