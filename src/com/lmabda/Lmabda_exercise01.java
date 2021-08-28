package com.lmabda;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lmabda 的基础语法
 */
public class Lmabda_exercise01 {
    @Test
    public void test1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello zzz");
            }
        };
        runnable.run();

        System.out.println("-----------------");

        Runnable runnable1 = () -> System.out.println("hello zzz");
        runnable1.run();
    }

    @Test
    public void test2() {
        Consumer<String> consumer = (x) -> System.out.println(x);
        consumer.accept("污渍永远的神");
    }

    @Test
    public void test3(){
        Comparator<Integer> comparator = (x,y) ->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
        Comparator<Integer> comparator = (x,y) -> Integer.compare(x,y);
    }

//    @Test
//    public void test5(){
//        Integer operation = operation(20, (x) -> x * x);
//        System.out.println(operation);
//        System.out.println(operation(100,(y) -> y + 100));
//    }

//    public Integer operation(Integer integer,Myfun myfun){
//        return myfun.getvalue(integer);
//    }
}
