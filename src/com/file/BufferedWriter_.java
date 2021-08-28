package com.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_ {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("e:\\zzz.txt",true));
        bufferedWriter.write("哪里都是你");
        bufferedWriter.newLine();
        bufferedWriter.write(65);
        bufferedWriter.newLine();
        bufferedWriter.write("美人鱼");
        bufferedWriter.close();
    }
}
