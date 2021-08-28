package com.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

/**
 * 演示PrintStream的使用
 *
 */

public class PrintStream_ {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out;
        printStream.print("sadasdas");
        printStream.write("啊飒飒的".getBytes());

        //修改打印流输入的位置
        //让他输出到e:\zzz.txt文件下
        System.setOut(new PrintStream("e:\\zzz.txt"));
        //美人鱼的眼泪会输出到e:\zzz.txt中
        System.out.println("美人鱼的眼泪");

        printStream.close();
    }
}
