package com.Hannuota;

public class HanNuoTa {
    public static void main(String[] args) {
        A a = new A();
        a.movo(3,'A','B','C');
    }
}
class A {
    public void movo(int num,char A ,char B ,char C){
        if(num == 1){
            System.out.println(A + "->" + C);
        }else {
            movo(num-1,A ,C ,B);
            System.out.println(A + "->" + C);
            movo(num-1,B ,A, C);
        }
    }
}