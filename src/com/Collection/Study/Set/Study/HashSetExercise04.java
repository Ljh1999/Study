package com.Collection.Study.Set.Study;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class HashSetExercise04 {
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate("2000", "5", "20");
        MyDate myDate2 = new MyDate("1999", "5", "11");
        MyDate myDate3 = new MyDate("2000", "5", "20");
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee_("老王", 5000, myDate1));
        hashSet.add(new Employee_("老刘", 7000, myDate2));
        hashSet.add(new Employee_("老王", 523, myDate3));
        Iterator iterator = hashSet.iterator();
//        for (Object o :hashSet) {
//            System.out.println(o);
//        }
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }
    }
}

class Employee_ {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee_(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee_{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_ employee_ = (Employee_) o;
        return  Objects.equals(name, employee_.name) &&
                Objects.equals(birthday, employee_.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,birthday);
    }
}

class MyDate {
    private String year;
    private String month;
    private String day;

    public MyDate(String year, String month, String day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return Objects.equals(year, myDate.year) &&
                Objects.equals(month, myDate.month) &&
                Objects.equals(day, myDate.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }
}