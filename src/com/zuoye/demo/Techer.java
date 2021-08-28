package com.zuoye.demo;

public class Techer {
    private String name;
    private int age;
    private String post;
    private double salary;

    public Techer(String name, int age, String post, double salary) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public String introduce(){
        return " 姓名：" + name + " 年龄：" + age + " 职称：" +
                post + " 基本工资：" + salary;
    }
}
