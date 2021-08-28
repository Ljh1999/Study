package com.override.study;

public class Test {
    public static void main(String[] args) {
        Person person = new Person(001,"小明");
        System.out.println(person.say());
        Student student = new Student(002,"小明",1806,88);
        System.out.println(student.say());
    }
}