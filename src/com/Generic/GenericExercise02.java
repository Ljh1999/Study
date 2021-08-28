package com.Generic;

import java.util.ArrayList;
import java.util.Comparator;

@SuppressWarnings({"all"})
public class GenericExercise02 {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();
        MyDate myDate1 = new MyDate(1999, 5, 16);
        MyDate myDate2 = new MyDate(1999, 5, 12);
        MyDate myDate3 = new MyDate(1999, 5, 26);
        list.add(new Employee("罗嘉豪", 50000, myDate1));
        list.add(new Employee("彭帅", 40000, myDate2));
        list.add(new Employee("罗嘉豪", 30000, myDate3));
        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                if (!(o1 instanceof Employee && o1 instanceof Employee)) {
                    return 0;
                }
                if (!(o1.getName() == o2.getName())) {
                    return (o1.getName()).compareTo(o2.getName());
                }
              return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println(list);
    }
}

class Employee {
    private String name;
    private double salary;

    public String getName() {
        return name;
    }

    public Employee(String name, double salary, MyDate birthday) {
        this.name = name;
        this.salary = salary;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "\nEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", birthday=" + birthday +
                '}';
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    private MyDate birthday;
}

class MyDate implements Comparable<MyDate> {
    private int year;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    private int month;
    private int day;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public int compareTo(MyDate o) {
        int year = this.year - o.getYear();
        if (year != 0) {
            return year;
        }
        int month = this.month - o.getMonth();
        if (month != 0) {
            return month;
        }
        return day - o.getDay();
    }
}