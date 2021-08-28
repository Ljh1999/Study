package com.single;

/**
 * 饿汉式单例模式
 */
public class singleTon {
    public static void main(String[] args) {
        GirlFriend instance = GirlFriend.getInstance();
        System.out.println(instance);

        GirlFriend instance2 = GirlFriend.getInstance();
        System.out.println(instance2);

        System.out.println(instance == instance2);
    }
}

/**
 * 只能有一个女朋友
 */
class GirlFriend {
    private String name;

    /**
     * 在类的内部创建对象
     */
    private static GirlFriend gf = new GirlFriend("小红");

    /**
     * 将构造器私有化 防止直接new对象
     */
    private GirlFriend(String name) {
        this.name = name;
    }

    /**向外暴露一个静态的公共方法*/
    public static GirlFriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "GirlFriend{" +
                "name='" + name + '\'' +
                '}';
    }
}
