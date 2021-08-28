package com.file;

import java.io.*;

/**
 *
 * 通过转换流解决乱码问题
 * 将 FileInputStream 字节流 转换成 字符流 InputStreamReader，指定编码 gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new FileReader("e:\\zzz.txt"));
//        String s = bufferedReader.readLine();
//        System.out.println(s);
//
//        bufferedReader.close();

        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("e:\\zzz.txt"), "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            System.out.println(s);
        }
        bufferedReader.close();
    }
}
