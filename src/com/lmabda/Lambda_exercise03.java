package com.lmabda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大核心函数式接口
 */
public class Lambda_exercise03 {
    // Consumer<T> 消费性接口
    // void accpet();
    @Test
    public void test1() {
        happy(1000, (m) -> System.out.println("消费" + m + "元"));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }


    //Supplier<T> 供给型接口
    // T get();
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer integer : numList) {
            System.out.println(integer);
        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = supplier.get();
            list.add(integer);
        }
        return list;
    }

    //Function<T,R> 函数型接口
    // R apply(T t);
    @Test
    public void test3() {
        String s = fiterString("污渍yyds", (x) -> x.substring(2, x.length()));
        System.out.println(s);
    }

    public String fiterString(String str, Function<String, String> fun) {
        return fun.apply(str);
    }


    // Predicate<T> 断言型接口
    // boolean test(T t);
    @Test
    public void test4() {
        List<String> strings = Arrays.asList("aaa", "zxcvb", "wuziyyds", "sherry");
        List<String> fiter = fiter(strings, (x) -> x.length() > 3);
        for (String s : fiter) {
            System.out.println(s);
        }
    }

    public List<String> fiter(List<String> str, Predicate<String> predicate) {
        List<String> strlist = new ArrayList<>();
        for (String s : str) {
            if (predicate.test(s)) {
                strlist.add(s);
            }
        }
        return strlist;
    }
}
