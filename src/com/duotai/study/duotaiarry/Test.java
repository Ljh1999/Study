package com.duotai.study.duotaiarry;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[5];
        people[0] = new Person("小宝贝",20);
        people[1] = new Student("赵洋", 22, 88);
        people[2] = new Student("邓志刚", 20, 88);
        people[3] = new Teacher("王老师", 30, 3000);
        people[4] = new Teacher("徐老师", 50, 4000);
        int[] arr = {100,5,9,60,1};
        for (int i = 0; i < people.length; i++) {
            Arrays.sort(arr);
            System.out.println(people[i].say());
            if(people[i] instanceof Student){
                Student student = (Student) people[i];
                student.study();
            }else if(people[i] instanceof Teacher){
                Teacher teacher = (Teacher) people[i];
                teacher.teach();
            }else if(people[i] instanceof Person) {
            }
            else {

            }

        }
    }
}
