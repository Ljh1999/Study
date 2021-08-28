package com.single;

/*
  懒汉式单例模式
 */
public class singleTon2 {
    public static void main(String[] args) {
        Cat instance = Cat.getInstance();
        System.out.println(instance);
    }
}

class Cat {
    private String name;
    //定义一个static静态属性对象
    private static Cat cat;

    //将构造器私有化
    private Cat(String name) {
        this.name = name;
    }

    //提供一个公共的static方法，可以返回一个Cat对象
    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("小白猫");
        }
        return cat;
    }

    //改写成线程安全 方式一：效率稍差
//    public static Cat getInstance() {
//        synchronized (Cat.class) {
//            if (cat == null) {
//                cat = new Cat("小白猫");
//            }
//            return cat;
//        }
//    }

    //改写成线程安全 方式二：效率更高
//    public static Cat getInstance() {
//        if(cat == null) {
//            synchronized (Cat.class) {
//                if (cat == null) {
//                    cat = new Cat("小白猫");
//                }
//            }
//        }
//        return cat;
//    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
