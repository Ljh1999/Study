package com.zuoye.demo.demo13;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }


    public void showinfotea() {
        System.out.println("老师信息如下：");
        System.out.println(super.showinfo());
        System.out.println("工龄：" + work_age);
        teach();
        System.out.println(play());
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }
    public void teach(){
        System.out.println("我承诺，我会认真教学。");
    }
}
