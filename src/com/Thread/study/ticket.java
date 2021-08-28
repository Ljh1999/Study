package com.Thread.study;

public class ticket {
    public static void main(String[] args) {
//        sellticket sellticket1 = new sellticket();
//        sellticket sellticket2 = new sellticket();
//        sellticket sellticket3 = new sellticket();
//        sellticket1.start();
//        sellticket2.start();
//        sellticket3.start();
        sellticket sellticket = new sellticket();
        new Thread(sellticket).start();
        new Thread(sellticket).start();
        new Thread(sellticket).start();
    }
}

class sellticket implements Runnable {
    private static int ticketNum = 100;
    private boolean loop = true;

    public /*synchronized*/ void sell() {
        synchronized (this) {
            if (ticketNum <= 0) {
                System.out.println("票已售罄");
                loop = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 正在售票" + "余票为：" + (--ticketNum));
        }
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}
