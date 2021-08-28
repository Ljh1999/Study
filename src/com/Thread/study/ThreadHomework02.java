package com.Thread.study;


public class ThreadHomework02 {
    public static void main(String[] args) {
        A a = new A();
        Thread thread1 = new Thread(a);
        Thread thread2 = new Thread(a);
        thread1.setName("用户A");
        thread2.setName("用户B");
        thread1.start();
        thread2.start();
    }
}

class A implements Runnable {
    private int money = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (money < 1000) {
                    System.out.println("余额不足，不能取款");
                    break;
                }
                money -= 1000;
                System.out.println(Thread.currentThread().getName() + "取钱1000元：" + "余额为：" + money);
            }
            try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}
