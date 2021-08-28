package com.EnumExercise;

public class Homework05 {
    public static void main(String[] args) {
        A a = new A();
        a.inner();
    }
}
class A{
    private final String NAME="A的name";
    public void inner(){
        class B{
            private final String NAME ="B的name";
            public void show(){
                System.out.println("name = " + NAME + " A中的常量name =" + A.this.NAME);
            }
        }
        B b = new B();
        b.show();
    }
}