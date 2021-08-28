package com.Abstract.study;

public class TemplateTest {
    public static void main(String[] args) {
        A a = new A();
        a.jisuanTime();
        B b = new B();
        b.jisuanTime();
    }
}

class A extends Template {
    @Override
    public void job() {
        int sum = 0;
        for (int i = 1; i <= 8000000; i++) {
            sum += i;
        }
    }
}
class B extends Template {
    @Override
    public void job() {
        int sum = 0;
        for (int i = 1; i <= 8000000; i++) {
            sum *= i;
        }
    }
}
