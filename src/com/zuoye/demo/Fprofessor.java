package com.zuoye.demo;

public class Fprofessor extends Techer {
    public Fprofessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() +" 副教授工资级别为基本工资*1.2："+ getSalary() * 1.2;
    }
}
