package com.file;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * 演示FileReader 字符输入流的使用
 */
public class Reader {
    public static void main(String[] args) {

    }
    //单个字符读取文件
    @Test
    public void FileReader01() {
        FileReader fileReader = null;
        int readerData = 0;
        try {
            fileReader = new FileReader("e:\\zzz.txt");
            while ((readerData = fileReader.read()) != -1) {
                System.out.print((char) readerData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //字符数组读取文件
    @Test
    public void FileReader02() {
        FileReader fileReader = null;
        int readerLength = 0;
        char[] chars = new char[8];
        try {
            fileReader = new FileReader("e:\\zzz.txt");
            while ((readerLength = fileReader.read(chars)) != -1) {
                System.out.print(new String(chars,0,readerLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
