package com.jdbc.dao.pojo;

public class Student {
    private  Integer studentid;
    private String name;
    private Integer age;
    private Integer classid;

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentid=" + studentid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", classid=" + classid +
                '}';
    }

    public Integer getStudentid() {
        return studentid;
    }

    public void setStudentid(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
