package com.fengzhuang.study;

public class demo1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("罗嘉豪");
        person.setAge(30);
        person.setSalary(3000);
        System.out.println(person.info());

        Person person1 = new Person("邓志刚", 200, 5000);
        System.out.println(person1.info());
    }
}

class Person {
    public String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println(" 长度必须在2-6之间");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 2 && age <= 100) {
            this.age = age;
        } else {
            System.out.println(" 设置的年龄不合法");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private double salary;

    public String info() {
        return "name = " + name + " age=" + age + " salary=" + salary;
    }
}