package com.file;

import java.io.*;

public class Homework01 {
    public static void main(String[] args) throws IOException {
        File file = new File("e:\\mytemp");
        if (!(file.exists())) {
            if (file.mkdir()) {
                System.out.println("创建目录成功");
            } else {
                System.out.println("创建目录失败");
            }
        }
        file = new File("e:\\mytemp\\hello.txt");
        if (!file.exists()) {
            if (file.createNewFile()) {
                System.out.println("创建文件成功");
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("hello,world~");
                fileWriter.close();
            } else {
                System.out.println("创建文件失败");
            }
        } else {
            System.out.println("文件已存在");
        }
    }
}
