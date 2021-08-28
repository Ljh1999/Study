package com.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.Duration;
import java.time.Instant;

/**
 * 利用通道完成文件的复制（非直接缓冲区）
 */
public class testChannel {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inchannel = null;
        FileChannel outchannel = null;
        //非直接缓冲区
        try {
            Instant start = Instant.now();
            fis = new FileInputStream("e:\\计算机基础书籍\\书.jpg");
            fos = new FileOutputStream("e:\\书2.jpg");
            //获取通道
            inchannel = fis.getChannel();
            outchannel = fos.getChannel();

            //分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //将通道里的数据读入缓冲区
            while (inchannel.read(buf) != -1) {
                buf.flip();
                outchannel.write(buf);
                buf.clear();
            }

            Instant end = Instant.now();
            System.out.println("耗时为：" + Duration.between(start,end).toMillis());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(outchannel != null){
                try {
                    outchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(inchannel != null){
                try {
                    inchannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
