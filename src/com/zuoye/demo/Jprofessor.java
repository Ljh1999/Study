package com.zuoye.demo;

public class Jprofessor extends Techer {
    public Jprofessor(String name, int age, String post, double salary) {
        super(name, age, post, salary);
    }

    @Override
    public String introduce() {
        return super.introduce() + " 讲师工资级别为基本工资*1.1" + getSalary() * 1.1;
    }
}
