package com.Final;

public class FinalDeties {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.area());
    }
}

class Circle{
    private double radius;
    private final double PI = 3.14;
    //private final double PI;


    public Circle(double radius) {
        this.radius = radius;
    }

    //        public Circle() {
//        PI = 3.14;
//    }
//    {
//        PI = 3.14;
//    }
    public double area(){
        return PI * radius * radius;
    }
}