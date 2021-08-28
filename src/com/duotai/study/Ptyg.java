package com.duotai.study;

public class Ptyg extends Emoloyee {
    public Ptyg(String name, double salary) {
        super(name, salary);
    }

    public void  work(){
        System.out.println(" 普通员工：" + getName() + "正在工作");
    }

    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
