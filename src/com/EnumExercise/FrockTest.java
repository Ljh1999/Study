package com.EnumExercise;

public class FrockTest {
    public static void main(String[] args) {
        int nextNum = Frock.getNextNum();
        System.out.println(nextNum);
        int nextNum1 = Frock.getNextNum();
        System.out.println(nextNum1);
        Frock frock = new Frock();
        System.out.println(frock.getSerialNumber());
        Frock frock1 = new Frock();
        System.out.println(frock1.getSerialNumber());
        Frock frock2 = new Frock();
        System.out.println(frock2.getSerialNumber());
    }
}

class Frock{
    private static int currentNum=100000;

    public Frock() {
        serialNumber = getNextNum();
    }

    private int serialNumber;

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }
}