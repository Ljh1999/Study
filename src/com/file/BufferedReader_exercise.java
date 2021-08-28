package com.file;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReader_exercise {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("e:\\zzz.txt"));
        int Line;
        while ((Line = bufferedReader.read()) != -1){
            System.out.print((char)Line);
        }
        bufferedReader.close();
    }
}
