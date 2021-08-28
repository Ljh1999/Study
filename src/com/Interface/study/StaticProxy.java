package com.Interface.study;

/**
 * 静态代理案例
 */
public class StaticProxy {
    public static void main(String[] args) {
        JugProxy jugProxy = new JugProxy(new Jug());
        jugProxy.gank();
    }
}

interface Game {
    void gank();
}

//被代理类
class Jug implements Game {
    @Override
    public void gank() {
        System.out.println("打野抓人控龙");
    }
}

//代理类
class JugProxy implements Game {

    private Game game;

    public JugProxy(Game game) {
        this.game = game;
    }

    @Override
    public void gank() {
        System.out.println("代替我去抓人");
        game.gank();
    }
}