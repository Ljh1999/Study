package com.file;

import java.io.*;
import java.io.OutputStream;

/**
 *
 * 演示反序列化的使用
 */
public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e:\\data.aaa"));
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());
        Object obj = objectInputStream.readObject();
        System.out.println(obj);
        Dog dog = (Dog)obj;
        System.out.println(dog.getName());

        objectInputStream.close();
    }
}
