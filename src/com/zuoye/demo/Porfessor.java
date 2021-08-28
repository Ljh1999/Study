package com.zuoye.demo;

public class Porfessor extends Techer {
    public Porfessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() + " 教授工资级别为基本工资*1.3" + getSalary() * 1.3;
    }
}
