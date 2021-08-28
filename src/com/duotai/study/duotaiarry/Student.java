package com.duotai.study.duotaiarry;

public class Student extends Person {
    private double score;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }
    public  void  study(){
        System.out.println(" 学生：" + getName() + "正在学java");
    }
    @Override
    public String say() {
        return super.say() + " 成绩=" + score;
    }
}
