package com.file;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 演示FileInputStream的使用（字节输入流  文件-->程序）
 */
public class InputStream {
    public static void main(String[] args) {

    }
    //演示读取文件  单个字节的读取，效率比较低
    @Test
    public void readFile01() {
        FileInputStream fileInputStream = null;
        int readData = 0;
        try {
            fileInputStream = new FileInputStream("e:\\hello.txt");
            //如果返回-1，表示读取到结尾
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char) readData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //演示读取文件  多个字节
    @Test
    public void readFile02() {
        FileInputStream fileInputStream = null;
        int readLenght = 0;
        byte[] bytes = new byte[8];
        try {
            fileInputStream = new FileInputStream("e:\\hello.txt");
            //如果返回-1，表示读取到结尾
            while ((readLenght = fileInputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes,0,readLenght));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}