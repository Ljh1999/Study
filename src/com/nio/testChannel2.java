package com.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;

//利用通道完成文件的复制（直接缓冲区）
public class testChannel2 {
    @Test
    public void test1() {
        try {
            Instant start = Instant.now();
            FileChannel inChannel = FileChannel.open(Paths.get("e:\\计算机基础书籍\\书.jpg"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("e:\\书.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE_NEW);
            //内存映射文件
            MappedByteBuffer inmap = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outmap = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            //直接对缓冲区的数据进行读写操作
            byte[] bytes = new byte[inmap.limit()];
            inmap.get(bytes);
            outmap.put(bytes);

            inChannel.close();
            outChannel.close();
            Instant end = Instant.now();
            System.out.println("耗时" + Duration.between(start, end).toMillis());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通道之间的数据传输
    @Test
    public void test2() {
        try {
            FileChannel inchannel = FileChannel.open(Paths.get("e:\\书2.jpg"), StandardOpenOption.READ);
            FileChannel outchannel = FileChannel.open(Paths.get("e:\\书4.jpg"), StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.CREATE);

            inchannel.transferTo(0, inchannel.size(), outchannel);
            //outchannel.transferFrom(inchannel,0,inchannel.size());

            inchannel.close();
            outchannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //分散读取和聚集写入
    @Test
    public void test3() {
        try {
            RandomAccessFile rw = new RandomAccessFile("e:\\1.txt", "rw");
            //得到通道
            FileChannel channel = rw.getChannel();
            //分配指定大小的缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(100);
            ByteBuffer allocate1 = ByteBuffer.allocate(1024);
            //分散读取
            ByteBuffer[] bufs = {allocate, allocate1};
            channel.read(bufs);
            for (int i = 0; i < bufs.length; i++) {
                bufs[i].flip();
            }
            System.out.println(new String(bufs[0].array(), 0, allocate.limit()));
            System.out.println("------------------------------");
            System.out.println(new String(bufs[1].array(), 0, allocate1.limit()));

            //聚集写入
            RandomAccessFile rw1 = new RandomAccessFile("e:\\2.txt", "rw");
            FileChannel channel1 = rw1.getChannel();
            channel1.write(bufs);

            channel.close();
            rw.close();
            rw1.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //字符集 : Charset
    //编码：字符串 -> 字节数组
    //解码：字节数组 -> 字符串
    @Test
    public void test4(){
        //查看所有字符集
//        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
//        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
//        for (Map.Entry<String, Charset> entry : entries) {
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

        //指定编码
        Charset gbk = Charset.forName("GBK");
        //编码器
        CharsetEncoder charsetEncoder = gbk.newEncoder();
        //解码器
        CharsetDecoder charsetDecoder = gbk.newDecoder();

        //分配指定大小的字符缓冲区
        CharBuffer charbuf = CharBuffer.allocate(1024);
        //放入数据
        charbuf.put("哪里都是你");
        //切换到读取数据模式
        charbuf.flip();

        try {
            //编码
            ByteBuffer encode = charsetEncoder.encode(charbuf);
            for (int i = 0; i < 10; i++) {
              System.out.println(encode.get());
            }
            //切换到读取数据模式
            encode.flip();
            //解码
            CharBuffer decode = charsetDecoder.decode(encode);
            System.out.println(decode.toString());
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }

        //分配指定大小的字节缓冲区
        ByteBuffer bytebuf = ByteBuffer.allocate(1024);

    }
}
