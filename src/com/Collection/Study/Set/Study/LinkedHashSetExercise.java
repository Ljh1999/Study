package com.Collection.Study.Set.Study;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        //分析LinkedHashSet底层机制
        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘",1001));
        set.add(123);
        set.add("LJH");
        System.out.println(set);
    }
}
class Customer{
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
