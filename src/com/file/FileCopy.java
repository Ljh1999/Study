package com.file;

import java.io.*;

/**
 * 完成文件拷贝
 */

public class FileCopy {
    public static void main(String[] args) {
        //将e：\\图片下的图片拷贝到d：\\下
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        int readLength = 0;
        byte[] bytes = new byte[1024];
        try {
            fileInputStream = new FileInputStream("e:\\图片\\《昨日青空》海报8k图片_彼岸图网.jpg");
            fileOutputStream = new FileOutputStream("d:\\《昨日青空》海报8k图片_彼岸图网.jpg");
            while ((readLength = fileInputStream.read(bytes)) != -1) {
                //边读边写
                fileOutputStream.write(bytes, 0, readLength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
