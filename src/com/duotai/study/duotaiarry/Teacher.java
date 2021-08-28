package com.duotai.study.duotaiarry;

public class Teacher extends Person {
    private double saary;

    public double getSaary() {
        return saary;
    }

    public void setSaary(double saary) {
        this.saary = saary;
    }

    public Teacher(String name, int age, double saary) {
        super(name, age);
        this.saary = saary;
    }
    public void teach(){
        System.out.println(" 教师 ：" + getName() + " 正在教JAVA");
    }
    @Override
    public String say() {
        return super.say() + " 薪水=" + saary;
    }
}
