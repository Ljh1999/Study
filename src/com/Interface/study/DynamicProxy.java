package com.Interface.study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理案例
 */
public class DynamicProxy {
    public static void main(String[] args) {
        Man man = new Man();
        Person proxyInstance = (Person) ProxyFactory.getProxyInstance(man);
        proxyInstance.ert("排骨");
        proxyInstance.sleep();
    }
}

//接口
interface Person {
    void ert(String food);

    void sleep();
}

//增强
class Enhance {
    public void before() {
        System.out.println("吃饭前要洗手，睡觉前要洗脸");
    }

    public void after() {
        System.out.println("吃饭后要洗碗，睡醒后要刷牙");
    }
}

//被代理类
class Man implements Person {
    @Override
    public void ert(String food) {
        System.out.println("男人喜欢吃" + food);
    }

    @Override
    public void sleep() {
        System.out.println("男人喜欢睡觉");
    }
}

//代理工厂，能够创建对应的代理类
class ProxyFactory {
    public static Object getProxyInstance(Object obj) { //obj:需要代理的对象
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl();
        invocationHandler.getObjcet(obj);
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), invocationHandler);
        return o;

    }
}

class InvocationHandlerImpl implements InvocationHandler {
    private Object object;

    public void getObjcet(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Enhance enhance = new Enhance();
        enhance.before();
        Object invoke = method.invoke(object, args);
        enhance.after();
        return invoke;
    }
}