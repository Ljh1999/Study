package com.file;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 演示 转换输出流OutputStreamWriter 的使用
 * 把FileOutputStream 字节流转成 OutputStreamWriter 字符流
 * 指定编码方式 gbk/utf-8
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String charSet = "gbk";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("e:\\abc.txt"),charSet);
        outputStreamWriter.write("在有眼泪的雨里，哪里都是你");

        outputStreamWriter.close();
    }
}

