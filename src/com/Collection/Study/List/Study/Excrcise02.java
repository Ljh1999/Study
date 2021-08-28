package com.Collection.Study.List.Study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Excrcise02 {
    public static void main(String[] args) {
        Dog dog = new Dog("小白",123);
        Dog dog1 = new Dog("小黑",12);
        Dog dog2 = new Dog("小妞",1);
        List list = new ArrayList();
        list.add(dog);
        list.add(dog1);
        list.add(dog2);
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Object dogs = iterator.next();
            System.out.println("Dog = " + dogs);
        }

    }
//        for (Object obj : arrayList){
//               System.out.println(" Dog=" + obj);
//        }
    }

class Dog{
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
