package com.NiMinginner;

public class Test {
    public static void main(String[] args) {
        Cell cell = new Cell();
        cell.aa(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cell.aa(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}

interface Bell{
    void ring();
}

class Cell{
    public static void aa(Bell bell){
        bell.ring();
    }
}