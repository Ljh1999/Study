package com.Collection.Study.Set.Study;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedHashSetExercise02 {
    public static void main(String[] args) {
        Set set = new LinkedHashSet();
        set.add(new Car("奥拓",10000));
        set.add(new Car("奥迪",300000));
        set.add(new Car("法拉利",10000000));
        set.add(new Car("奥迪",300000));
        set.add(new Car("保时捷",70000000));
        set.add(new Car("奥迪",300000));
        System.out.println("set = " +set);
    }
}
class Car{
    private String name;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.price, price) == 0 &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    private double price;
}