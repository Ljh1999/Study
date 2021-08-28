package com.reflection;

/**
 * 演示获得Class类对象的6种方式
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
         String classpath = "com.reflection.Car";
         //在编译阶段 -> 通过Class.forName
        Class<?> aClass = Class.forName(classpath);
        System.out.println(aClass);

        //在加载阶段 -> 通过类名.class
        Class<Car> carClass = Car.class;
        System.out.println(carClass);

        //在运行阶段 -> 通过对象.getclass()
        Car car = new Car();
        Class<? extends Car> aClass1 = car.getClass();
        System.out.println(aClass1);

        //在类加载阶段 -> 通过类加载器得到Class对象
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?> aClass2 = classLoader.loadClass(classpath);
        System.out.println(aClass2);

        //上面4中获取到的其实都是同一个对象
        System.out.println(aClass.hashCode());
        System.out.println(carClass.hashCode());
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());

        //基本数据类型获得Class对象 -> 通过基本数据类型.class
        Class<Integer> integerClass = int.class;
        System.out.println(integerClass);

        //基本数据类型对应的包装类获得Class对象 ->通过包装类.TYPE
        Class<Integer> type = Integer.TYPE;
        System.out.println(type);

    }
}
