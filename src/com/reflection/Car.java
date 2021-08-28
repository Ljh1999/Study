package com.reflection;

public class Car {
    public String brand = "宝马";
    public int price = 500000;
    public String red = "红色";
    private int age = 10;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", red='" + red + '\'' +
                '}';
    }
}
