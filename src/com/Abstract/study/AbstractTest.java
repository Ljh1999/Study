package com.Abstract.study;

public class AbstractTest {
    public static void main(String[] args) {
        Employee employee = new Manager("王经理", 001, 20000, 5000);
        employee.work();
        Employee employee1 = new CommonEmployee("刘师傅",002,2000);
        employee1.work();
    }
}

abstract class Employee{
    private String name;
    private int id;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}
class Manager extends Employee{
    private double bonus;

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("经理：" +getName() + " id = " + getId() +
                " 工资：" + getSalary()+" 奖金=" + bonus +" 工作中。。。");
    }
}
class CommonEmployee extends Employee{
    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("普通员工：" +getName() + "id=" + getId() +
                "工资：" + getSalary()+ "工作中。。。");
    }
}
