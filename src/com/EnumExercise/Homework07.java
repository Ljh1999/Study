package com.EnumExercise;

public class Homework07 {
    public static void main(String[] args) {
        Car car = new Car(-1);
        car.getAir().flow();
        Car car1 = new Car(50);
        car1.getAir().flow();
        Car car2 = new Car(1);
        car2.getAir().flow();
    }
}

class Car{
    private double tempreature;

    public Car(double tempreature) {
        this.tempreature = tempreature;
    }

    class Air{

        public void flow(){
            if(tempreature>40){
                System.out.println("吹冷气");
            }else if(tempreature<=40 && tempreature>=0){
                System.out.println("关闭空调");
            }else {
                System.out.println("吹暖气");
            }
        }
    }

    public Air getAir(){
       return new Air();
    }
}