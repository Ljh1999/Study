package com.Thread.study;

/**
 * 通过继承Thread类实现线程
 */
public class exercise01 extends Thread {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.start();
    }
}

class Cat extends Thread {
    int times = 0;
    @Override
    public void run() {

        while (true) {
            System.out.println("线程名：" + Thread.currentThread().getName() + "喵喵，我是小猫咪" + (++times));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(times == 8){
                break;
            }
        }
    }
}