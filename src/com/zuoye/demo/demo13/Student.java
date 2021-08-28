package com.zuoye.demo.demo13;

public class Student extends Person {
    private int stu_id;

    public Student(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    @Override
    public String play() {
        return super.play() + "足球";
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void showinfostu() {
        System.out.println("学生信息如下：");
        System.out.println(super.showinfo());
        System.out.println("学号：" +stu_id);
        study();
        System.out.println(play());
    }

    public void study(){
        System.out.println("我承诺，我会好好学习。");
    }
}
