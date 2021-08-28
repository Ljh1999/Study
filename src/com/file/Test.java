package com.file;

import java.io.BufferedReader;

public class Test {
    public static void main(String[] args) {
        BufferedReader_ bufferedReader_1 = new BufferedReader_(new FileReader_());
        bufferedReader_1.read();
        BufferedReader_ bufferedReader_2 = new BufferedReader_(new StringReader_());
        bufferedReader_2.read();
    }
}
abstract class Reader_{
//    public  void readFile(){};
//    public  void readString(){};
    public abstract void read();
}

class FileReader_ extends Reader_{
    @Override
    public void read() {
        System.out.println("读取文件");
    }
}

class StringReader_ extends Reader_{
    @Override
    public void read() {
        System.out.println("读取字符串");
    }
}

class BufferedReader_ extends Reader_{
    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }


    @Override
    public void read() {
        reader_.read();
    }
}