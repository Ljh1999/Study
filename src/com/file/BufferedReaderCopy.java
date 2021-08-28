package com.file;

import java.io.*;

public class BufferedReaderCopy {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("e:\\zzz.txt"));
            bufferedWriter = new BufferedWriter(new FileWriter("d:\\ccc.txt", true));
            String readLin;
            while ((readLin = bufferedReader.readLine()) != null) {
                bufferedWriter.newLine();
                bufferedWriter.write(readLin);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }
}
