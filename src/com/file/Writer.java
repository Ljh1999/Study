package com.file;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("e:\\zzz.txt");
            //写入单个字符
            fileWriter.write('H');
            //写入字符串
            fileWriter.write("罗嘉豪");
            //写入指定字符数组
            char[] chars ={'U','z','i'};
            fileWriter.write(chars);
            //写入指定字符数组的指定部分
            fileWriter.write(chars,0,3);
            //写入字符串的指定部分
            fileWriter.write("污渍，永远的神".toCharArray(),0,2);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
