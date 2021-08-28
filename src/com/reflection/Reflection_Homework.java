package com.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 练习1：通过反射修改私有成员变量
 */
public class Reflection_Homework {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        Class<?> aClass = Class.forName("com.reflection.PrivateTest");
        Object o = aClass.newInstance();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"helloworld");
        Method getName = aClass.getMethod("getName");
        System.out.println(getName.invoke(o));
    }
}
class PrivateTest{
    private String name = "hellokitty";

    public String getName() {
        return name;
    }

}
