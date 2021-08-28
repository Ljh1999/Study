package com.reflection;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 利用反射和File创建文件
 */
public class Reflection_Homework_02 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IOException {
        Class<?> aClass = Class.forName("java.io.File");
        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance("e:\\mynew.txt");
        Method createNewFile = aClass.getMethod("createNewFile");
        createNewFile.invoke(o);
    }
}
