package com.Thread.study;

public class join {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <=10 ; i++) {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " hi" + i);
            if(i == 5){
                T t = new T();
                Thread thread = new Thread(t);
                thread.start();
                //线程插队
                thread.join();
                //线程礼让
                //Thread.yield();
            }
        }
        System.out.println("主线程结束...");
    }
}

class T implements Runnable{

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " hello" + i);
        }
        System.out.println("子线程结束...");
    }
}
