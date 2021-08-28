package com.reflection;

import java.lang.reflect.Field;

public class reflection_menthod {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
          String classpath = "com.reflection.Car";
        Class<?> aClass = Class.forName(classpath);   //得到Class类对象 <?> 代表不确定的java类型
        System.out.println(aClass);
        System.out.println(aClass.getClass());
        System.out.println(aClass.getPackage().getName());
        Object o = aClass.newInstance();     //通过反射创建对象
        System.out.println(o);
        Field brand = aClass.getField("brand");    //得到指定字段
        System.out.println(brand.getName());
        System.out.println(brand.get(o));
        System.out.println(aClass.getName());
        Field[] fields = aClass.getFields();     //得到所有字段
        for (int i = 0; i <fields.length ; i++) {
            System.out.println(fields[i].getName());  //获取所有字段
            System.out.println(fields[i].get(o));  //获取所有字段属性值
        }
        Field age = aClass.getDeclaredField("age");
        System.out.println(age.getName());
    }
}
