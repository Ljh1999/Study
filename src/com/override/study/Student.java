package com.override.study;

public class Student extends Person {
    private int id;
    private double score;

    public Student(int id, String name, int id1, double score) {
        super(id, name);
        this.id = id1;
        this.score = score;
    }

    public Student() {

    }
    public String say(){
        return super.say()+" id=" + id + " score=" + score;
    }
}
