package com.zuoye.demo.Employee.demo;

public class test {
    public static void main(String[] args) {
        Employee employee = new Worker("老罗",2000);
        employee.yearsalary();
        Employee employee1 = new Teacher("徐老师",2500,100,30);
        employee1.yearsalary();
        Employee employee2 = new Scietist("陈科学家",1000,50000);
        employee2.yearsalary();
    }
}
