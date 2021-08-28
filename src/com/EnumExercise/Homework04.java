package com.EnumExercise;

public class Homework04 {
    public static void main(String[] args) {
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new comput() {
            @Override
            public double work(double n1, double n2) {
                  return n1 + n2;
            }
        },10,20);
    }
}

interface comput{
    double work(double n1,double n2);
}
class Cellphone{
    public void testWork(comput c,double n1,double n2){
        double res = c.work(n1,n2);
        System.out.println(" 计算的结果为："+ res);
    }
}