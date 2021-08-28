package com.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class reflection_exercise01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classname = properties.getProperty("classpath");  //com.reflection.Cat
        String methodname = properties.getProperty("method");    //cry
        System.out.println(classname);
        System.out.println(methodname);

        //1.加载类，放回Class类型的对象
        Class<?> aClass = Class.forName(classname);
        //2.通过返回的对象得到你加载的类的对象实例
        Object o = aClass.newInstance();
        //打印出得到对象实例的运行类型
        System.out.println("返回对象实例的运行类型为" + o.getClass());
        //3.通过返回的对象得到你加载的类的方法对象
        //即：在反射中，可以吧方法视为对象（万物皆对象）
        Method method = aClass.getMethod(methodname);
        //即通过方法对象来实现调用方法
        //传统方法：对象.方法()
        //反射机制：方法.invoke(对象)
        method.invoke(o);

        Field age = aClass.getField("age");
        System.out.println(age);
        Object o1 = age.get(o);
        System.out.println(o1);

        Constructor<?> constructor = aClass.getConstructor();
        System.out.println(constructor);

        Constructor<?> constructor1 = aClass.getConstructor(String.class, int.class);
        System.out.println(constructor1);
    }
}
