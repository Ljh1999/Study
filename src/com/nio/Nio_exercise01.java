package com.nio;

import java.nio.ByteBuffer;

/**
 * 缓冲区
 */

public class Nio_exercise01 {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        System.out.println("-----allocate()指定容量大小为1024的缓冲区-----");
        System.out.println(allocate.mark());
        System.out.println("-----put()写入4个字节-----");
        String str = "yyds";
        //存入数据
        allocate.put(str.getBytes());
        System.out.println(allocate.mark());
        //切换读取数据模式
        allocate.flip();
        System.out.println("-----flip()切换为读取模式-----");
        System.out.println(allocate.mark());

        byte[] bytes = new byte[allocate.limit()];
        System.out.println("-----get()读取数据-----");
        allocate.get(bytes);
        System.out.println(new String(bytes));
        System.out.println(allocate.mark());

        //可重复读
        allocate.rewind();
        System.out.println("-----rewind()可重复读-----");
        System.out.println(allocate.mark());

        //清空缓冲区,虽然清空了缓冲区，但是里面的数据依然存在，处于被“遗忘状态”
        allocate.clear();
        System.out.println("-----clear()清空缓冲区-----");
        System.out.println(allocate.mark());
        System.out.println((char)allocate.get());
    }
}
