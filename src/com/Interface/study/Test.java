package com.Interface.study;

public class Test {
    public static void main(String[] args) {
            new C().pX();
    }
}
interface D{
    void say();
}
interface A extends D{
    int x= 0;
}
class B{
    int x = 1;
}
class C extends B {
    public void pX(){
        System.out.println(super.x + " " + A.x);
    }
}