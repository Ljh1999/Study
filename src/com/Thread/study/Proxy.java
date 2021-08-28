package com.Thread.study;

/**
 * 代理代理类，模拟了一个极简的Thread类
 */
public class Proxy {
    public static void main(String[] args) {
        Tiger tiger = new Tiger();
        ThreadProxy thread = new ThreadProxy(tiger);
        thread.start();
    }
}

class ThreadProxy implements Runnable{
    private Runnable target = null;

    public ThreadProxy(Runnable target) {
        this.target = target;
    }
    public void start(){
        start0();
    }
    public void start0(){
        run();
    }
    @Override
    public void run() {
         if(target!=null){
             target.run();
         }
    }
}

class  Animal{}
class Tiger extends Animal implements Runnable{
    @Override
    public void run() {
         System.out.println("老虎嗷嗷叫...");
    }
}
