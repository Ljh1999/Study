package com.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * 演示PrintWriter的使用
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {
//        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\zzz.txt", true));
        PrintWriter printWriter = new PrintWriter(System.out);
//        printWriter.print("黑夜问白天");
        printWriter.write("哪里都是你");
        printWriter.close();
    }
}
