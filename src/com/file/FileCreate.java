package com.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * 演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }
    //第一种方式
    @Test
    public void newFile1(){
        File file = new File("e:\\text2.txt");
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //第二种方式
    @Test
    public void newFile2(){
        File file = new File("e:\\","text3.txt");
        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
