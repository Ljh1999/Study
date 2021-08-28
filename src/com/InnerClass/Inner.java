package com.InnerClass;

public class Inner { //外部其他类
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.m();
    }
}

class Outer{//外部类
     private int n =0;
     private void f(){System.out.println("f()方法被调用...");}
     public void m(){

      final class inner{ //局部内部类
              private int n = 100;
              public void c(){
                  System.out.println(n + " " + Outer.this.n);
                  f();
              }
         }
         inner inner = new inner();
         inner.c();
     }
}