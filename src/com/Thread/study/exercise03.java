package com.Thread.study;

@SuppressWarnings({"all"})
public class exercise03 {
    public static void main(String[] args) {
        T3 t3 = new T3();
        T4 t4 = new T4();
        Thread thread = new Thread(t3);
        Thread thread1 = new Thread(t3);
        thread.start();
        thread1.start();
    }
}
@SuppressWarnings({"all"})
class T3 implements Runnable {
    int count = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "hello , word!" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10){
                break;
            }
        }
    }
}
@SuppressWarnings({"all"})
class T4 implements  Runnable{
    int count  = 0;
    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + "hi!" + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10){
                break;
            }
        }
    }
}