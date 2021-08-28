package com.zuoye.demo.Employee.demo;

public class Scietist extends Employee {
    private double yearzhongjiang;

    public Scietist(String name, double salary, double yearzhongjiang) {
        super(name, salary);
        this.yearzhongjiang = yearzhongjiang;
    }

    @Override
    public void yearsalary() {
        System.out.println(" 科学家：" + getName() + " 年薪=" + ((getSalary() * 12) + yearzhongjiang));
    }

    public double getYearzhongjiang() {
        return yearzhongjiang;
    }

    public void setYearzhongjiang(double yearzhongjiang) {
        this.yearzhongjiang = yearzhongjiang;
    }
}
