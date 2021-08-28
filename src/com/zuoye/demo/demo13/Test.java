package com.zuoye.demo.demo13;

public class Test {
    public static void main(String[] args) {
        Person[] peoples = new Person[4];
        peoples[0] = new Student("小花",'女',20,202030644);
        peoples[1] = new Student("小明", '男', 22, 202030645);
        peoples[2] = new Teacher("徐老师",'女',44,12);
        peoples[3] = new Teacher("王老师",'男',55,16);
        Person p = null;
        for (int i = 0; i < peoples.length-1; i++) {
          for (int j = 0; j < peoples.length-i-1; j++) {
              if(peoples[j].getAge() < peoples[j+1].getAge()){
                  p = peoples[j];
                  peoples[j] = peoples[j+1];
                  peoples[j+1] = p;
              }
           }
        }
        Test test = new Test();
        test.info(peoples[1]);
    }

    public void info(Person person){
        if(person instanceof Student){
            Student student = (Student)person;
            student.showinfostu();
        }
        else if (person instanceof Teacher){
            Teacher teacher = (Teacher)person;
            teacher.showinfotea();
        }
        else {}
    }
}
