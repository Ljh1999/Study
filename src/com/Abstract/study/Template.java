package com.Abstract.study;

abstract public class Template {

    public abstract void job();

    public void jisuanTime(){
        long begin = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("经过的时间 " + (end - begin));
    }
}
