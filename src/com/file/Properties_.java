package com.file;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * 传统方法解决
 */
public class Properties_ {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("F:\\IntelliJ IDEA 2018.3.3\\work\\Study\\src\\mysql.properties"));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
//            String[] split = line.split("=");
//            if(split[0].equals("ip")) {
//                System.out.println(split[0] + ":" + split[1]);
//            }
        }
        bufferedReader.close();
    }
}

/**
 * 使用Properties类来完成对mysql.Properties文件的读取
 */
class Properties_02{
     @Test
    public void read() throws IOException {
         Properties properties = new Properties();
         properties.load(new FileReader("src\\mysql.properties"));
         //properties.list(System.out);
         System.out.println(properties);
         String user = properties.getProperty("user");
         String pwd = properties.getProperty("pwd");
         System.out.println("user = " + user);
         System.out.println("pwd = " + pwd);
     }
}

/**
 * 演示通过Properties类实现创建和修改文件
 */
class Properties_03{
    @Test
    public void create() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("charset","utf8");
        properties.setProperty("user","ljh");
        properties.setProperty("pwd","123456");
        properties.store(new FileWriter("src\\mysql2.properties"),null);
    }
}