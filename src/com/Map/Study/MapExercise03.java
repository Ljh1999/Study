package com.Map.Study;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class MapExercise03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("001", new Employee("001", "罗家豪", 1000));
        hashMap.put("002", new Employee("002", "彭帅", 123200));
        hashMap.put("003", new Employee("003", "谢祥聪", 4200));
        System.out.println("---使用keySet增强for---");
        Set set = hashMap.keySet();
        for (Object o : set) {
            Object o1 = hashMap.get(o);
            Employee e = (Employee) o1;
            if (e.getSalary() > 18000)
                System.out.println(e);
        }
        System.out.println("---使用keySet迭代器---");
        Iterator iterator1 = set.iterator();
        while (iterator1.hasNext()) {
            Object next =  iterator1.next();
            Employee emp = (Employee)hashMap.get(next);
            if(emp.getSalary()>18000){
                System.out.println(emp);
            }
        }
        System.out.println("---使用entrySet增强for---");
        Set set1 = hashMap.entrySet();
        for (Object o : set1) {
            Map.Entry entry = (Map.Entry) o;
            Object value = entry.getValue();
            Employee e = (Employee) value;
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }
        }
        System.out.println("---使用entrySet迭代器---");

        Iterator iterator = set1.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Employee e = (Employee) value;
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }
        }
    }
}

class Employee {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Employee(String id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    private double salary;
}