package com.file;

import java.io.*;

public class Homework02 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("e:\\zzz.txt"), "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        int i = 1;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(i + "." + line);
            i++;
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }
}
