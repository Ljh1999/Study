package com.file;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(new FileReader("F:\\IntelliJ IDEA 2018.3.3\\work\\Study\\src\\Cat.properties"));
        String name = properties.getProperty("name");
        String age = properties.getProperty("age");
        String color = properties.getProperty("color");
        Cat cat = new Cat(name, Integer.parseInt(age), color);
        System.out.println(cat);
        //序列化cat
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:\\Cat.dat"));
        objectOutputStream.writeObject(cat);
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e:\\Cat.dat"));
        Object obj = objectInputStream.readObject();
        System.out.println("反序列化回来的cat");
        System.out.println(obj);
        objectInputStream.close();
    }
}
class Cat implements Serializable {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}