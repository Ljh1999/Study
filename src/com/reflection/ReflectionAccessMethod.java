package com.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 通过反射操作方法
 */
public class ReflectionAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> aClass = Class.forName("com.reflection.Boss");
        Object o = aClass.newInstance();
        Method hi = aClass.getMethod("hi", String.class);
        hi.invoke(o, "美女");

        Method say = aClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(null, 100, "阿萨德", '男'));

        Object invoke = say.invoke(o, 200, "阿asd德", '男');
        System.out.println(invoke.getClass());  //class java.lang.String
    }
}

class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi" + s);
    }
}