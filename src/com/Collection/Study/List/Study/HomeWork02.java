package com.Collection.Study.List.Study;

import java.util.ArrayList;
import java.util.Iterator;

public class HomeWork02 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        Car car = new Car("宝马", 4000000);
        Car car1 = new Car("保时捷", 6000000);
        Car car2 = new Car("兰博基尼", 8000000);
        list.add(car);
        list.add(car1);
        list.add(car2);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.contains(car));
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        list.clear();
        System.out.println(list);
        ArrayList list1 = new ArrayList();
        list1.add(car);
        list1.add(car1);
        list1.add(car2);
        list.addAll(list1);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.containsAll(list1));
        list.removeAll(list);
        System.out.println(list);
        Iterator iterator = list1.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println(obj);
        }
        for (Object o :list1) {
            System.out.println(o);
        }

    }
}
class Car{
    private String name;
    private int price;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}