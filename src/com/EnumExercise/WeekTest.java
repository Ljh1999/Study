package com.EnumExercise;

public class WeekTest {
    public static void main(String[] args) {
        System.out.println("所有星期的信息如下：");
        Week[] values = Week.values();
        for(Week week : values){
            System.out.println(week);
        }
    }
}

//使用关键字
enum Week{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),THIRSDAY("星期四"),
    FRIDAY("星期五"),SATURDAY("星期六"),SUNDAY("星期天");

    private Week(String name) {
        this.name = name;
    }
    private String name;

    @Override
    public String toString() {
        return name;
    }
}

//自定义枚举类
//class Week{
//
//    private String Name;
//
//    private Week(String name) {
//        Name = name;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public static final Week MONDAY = new Week("星期一");
//    public static final Week TUESDAY = new Week("星期二");
//    public static final Week WEDNESDAY = new Week("星期三");
//    public static final Week THIRSDAY = new Week("星期四");
//    public static final Week FRIDAY = new Week("星期五");
//    public static final Week SATURDAY = new Week("星期六");
//    public static final Week SUNDAY = new Week("星期天");
//
//    @Override
//    public String toString() {
//        return "Week{" +
//                "Name='" + Name + '\'' +
//                '}';
//    }
//}