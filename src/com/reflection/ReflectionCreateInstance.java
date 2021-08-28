package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射创建实例
 */
public class ReflectionCreateInstance {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //通过无参构造器创建Class对象
        Class<?> aClass = Class.forName("com.reflection.User");
        Object o = aClass.newInstance();
        System.out.println(o);

        //通过public构造器创建对象
        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object ps = constructor.newInstance("ps");
        System.out.println(ps);

        //通过private构造器创建对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(int.class, String.class);
        //暴力破解
        declaredConstructor.setAccessible(true);
        Object xxc = declaredConstructor.newInstance(21, "xxc");
        System.out.println(xxc);

    }
}
class User{
    private int age = 10;
    private String name = "ljh";

    public User(){}

    public User(String name){
        this.name = name;
    }

    private User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}