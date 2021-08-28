package com.EnumExercise;


public class Homework06 {
    public static void main(String[] args) {

        Person person = new Person("唐僧", new Hores());
        person.common();
        person.passriver();
        person.fly();
    }
}

interface Vehicles {
    void work();
}

class Hores implements Vehicles {

    @Override
    public void work() {
        System.out.println("马儿");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("小船");
    }
}

class Plant implements Vehicles {

    @Override
    public void work() {
        System.out.println("飞机");
    }
}
class Factory {
    private static Hores hores = new Hores();//饿汉式
    private Factory(){} //构造器私有化
    public static Hores getHorse() {
        return hores;
    }

    public static Boat getBoat() {
      return new Boat();
    }
    public static Plant getPlant(){
        return new Plant();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void passriver() {
        if(!(vehicles instanceof Boat)){
            vehicles = Factory.getBoat();
        }
            vehicles.work();
    }


    public void common() {
        if(!(vehicles instanceof Hores)){
           vehicles = Factory.getHorse();
        }
            vehicles.work();
    }

    public void fly() {
        if(!(vehicles instanceof Plant)){
            vehicles = Factory.getPlant();
        }
        vehicles.work();
    }

}