package com.reflection;

import java.lang.reflect.Field;

/**
 * 演示反射操作属性
 */
public class ReflectionAccessProperty {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //得到Student类对应的Class对象
        Class<?> aClass = Class.forName("com.reflection.Student");
        //通过反射无参构造器创建对象
        Object o = aClass.newInstance();
        Field age = aClass.getField("age");
        age.set(o, 22);
        System.out.println(o);
        System.out.println(age.get(o));

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "zzz");
        name.set(null, "zzz");//因为是static的，才可以使用null
        System.out.println(o);
        System.out.println(name.get(o));
        System.out.println(name.get(null)); //因为是static的，才可以使用null
    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + ",name=" + name +
                '}';
    }
}