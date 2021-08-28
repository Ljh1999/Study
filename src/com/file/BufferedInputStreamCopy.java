package com.file;

import java.io.*;

public class BufferedInputStreamCopy {
    public static void main(String[] args) {
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        byte[] bytes = new byte[1024];
        int readlength = 0;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream("e:\\图片\\《人类Humankind》5k游戏壁纸5120x2880_彼岸图网.jpg"));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("e:\\《人类Humankind》5k游戏壁纸5120x2880_彼岸图网.jpg"));
            while ((readlength = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, readlength);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bufferedInputStream != null){
                    bufferedInputStream.close();
                }
                if(bufferedOutputStream != null){
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
