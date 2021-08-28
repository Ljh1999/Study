package com.Thread.study;


import java.util.Random;
import java.util.Scanner;

public class ThreadHomework01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}

class T1 extends Thread{
    public  static boolean loop = true;
    @Override
    public void run() {
         while (loop){
             Random random = new Random();
             int i = random.nextInt(100);
             System.out.println(" " + i);
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}

class T2 extends Thread{
    private Scanner scanner = new Scanner(System.in);
    @Override
    public void run() {
        while(true) {
            System.out.println("请输入字符：Q表示退出");
            char c = scanner.next().toUpperCase().charAt(0);
            if (c == 'Q') {
                T1.loop = false;
                System.out.println("B线程退出.");
                break;
            }
        }
    }
}