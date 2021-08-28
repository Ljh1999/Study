package com.file;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 演示FileOutputStream使用方法,将数据写入到文件中，如果文件不存在，则创建文件
 */
public class OutputStream {
    public static void main(String[] args) {

    }

    @Test
    public void WriterFile() {
        FileOutputStream fileOutputStream = null;
        String str = "Ljh,yyds";
        try {
            //fileOutputStream = new FileOutputStream("e:\\a.txt");表示覆盖
            fileOutputStream = new FileOutputStream("e:\\a.txt",true); //加true表示追加
            //写入一个字符
            fileOutputStream.write('H');
            //写入一个字符串,getBytes将字符串转成字符数组
            fileOutputStream.write(str.getBytes());
            //指定从字符数组取前3个字符
            fileOutputStream.write(str.getBytes(),0,3);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
