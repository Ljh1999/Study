package com.Generic;

import java.util.*;

public class GenericExercise01 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<Student>();
        students.add(new Student("赵洋",22));
        students.add(new Student("邓志刚",20));
        students.add(new Student("谢祥聪",22));
        System.out.println("---HashSet增强for---");
        for (Student s :students) {
            System.out.println(s);
        }
        
        System.out.println("---HashSet迭代器---");
        Iterator<Student> iterator2 = students.iterator();
        while (iterator2.hasNext()) {
            Student stu =  iterator2.next();
            System.out.println(stu);
        }
        HashMap<String, Student> hashMap = new HashMap<String, Student>();
        Student s1 = new Student("彭帅", 22);
        Student s2 = new Student("罗嘉豪", 22);
        Student s3 = new Student("张力鹏", 22);
        hashMap.put(s1.getName(), s1);
        hashMap.put(s2.getName(), s2);
        hashMap.put(s3.getName(), s3);
        //entrySet增强for
        System.out.println("---Hashmap---");
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        for (Map.Entry entry : entries) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        //entrySet迭代器
        Iterator<Map.Entry<String, Student>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Student> entry = iterator.next();
            System.out.println(entry);
        }
        //keyset增强for
        Set<String> strings = hashMap.keySet();
        for (String s : strings) {
            System.out.println(hashMap.get(s));
        }
        //keyset增强for
        Iterator<String> iterator1 = strings.iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println(hashMap.get(next).getName() + "-" + hashMap.get(next));
        }
    }
}

class Student {
    private String name;
    private int age;

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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}