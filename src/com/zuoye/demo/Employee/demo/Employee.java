package com.zuoye.demo.Employee.demo;

public class Employee {
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public void  yearsalary(){
        System.out.println(" 工人：" + name + " 年薪=" + salary * 12);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    private String name;
    private double salary;
}
