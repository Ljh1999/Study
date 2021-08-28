package com.Collection.Study.Set.Study;

import java.util.HashSet;
import java.util.Objects;

public class HashSetExercise03 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("老王",22));
        hashSet.add(new Employee("老张",23));
        hashSet.add(new Employee("老王",22));

        System.out.println(hashSet);
    }
}
class Employee{
    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    //    @Override
//    public boolean equals(Object obj) {
//        if(this == obj){
//            return true;
//        }
//        if(!(obj instanceof Employee)){
//            return false;
//        }
//        Employee e = (Employee)obj;
//        return this.name.equals(((Employee) e).name) && this.age==((Employee) e).age;
//    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}