package com.zuoye.demo.Employee.demo;

public class Teacher extends Employee {
    private double daysalary;
    private int day;

    public Teacher(String name, double salary, double daysalary, int day) {
        super(name, salary);
        this.daysalary = daysalary;
        this.day = day;
    }

    @Override
    public void yearsalary() {
        System.out.println(" 教师：" + getName() + " 年薪=" + ((getSalary() * 12) +(day * daysalary)));
    }

    public double getDaysalary() {
        return daysalary;
    }

    public void setDaysalary(double daysalary) {
        this.daysalary = daysalary;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
