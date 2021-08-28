package com.zuoye.demo;

public class TecherTest {
    public static void main(String[] args) {
        Techer techer = new Techer("徐老师", 38, "java老师", 5000);
        System.out.println(techer.introduce());
        Porfessor porfessor = new Porfessor("王教授", 50, "教授", 5000);
        System.out.println(porfessor.introduce());
        Fprofessor fprofessor = new Fprofessor("刘副教授", 48, "副教授", 5000);
        System.out.println(fprofessor.introduce());
        Jprofessor jprofessor = new Jprofessor("唐讲师", 43, "讲师", 5000);
        System.out.println(jprofessor.introduce());
    }
}
