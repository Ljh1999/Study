package com.lmabda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda_exercise02 {
    List<Employee> list = Arrays.asList(
            new Employee("小王", 34, 3333.33),
            new Employee("小刘", 37, 9999.99),
            new Employee("小罗", 43, 8888.88),
            new Employee("老谢", 65, 7777.77),
            new Employee("帅多", 32, 5555.55)
    );

    //定制排序
    @Test
    public void test1() {
        Collections.sort(list, (x, y) -> {
            if (x.getAge() == y.getAge()) {
                return x.getName().compareTo(y.getName());
            } else {
                return y.getAge() - x.getAge();
            }
        });
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    @Test
    public void test2() {
        String s = "asdwqe";
        String change = change(s, (x) -> x.toUpperCase());
        System.out.println(change);

        String ss = "aabbccdd";
        String change1 = change(ss, (y) -> y.substring(2, 4));
        System.out.println(change1);
    }

    //转换字符串
    public String change(String srr, Myfun myfun) {
        return myfun.getvalue(srr);
    }

    @Test
    public void test3(){
        Long num = num(100L,100L, (x,y) -> x + y);
        System.out.println(num);

        Long num1 = num(20L,20L, (x,y) -> x * y);
        System.out.println(num1);

    }


    public Long num(Long l1,Long l2, Myfunction<Long, Long> myfunction) {
        return myfunction.getNum(l1,l2);
    }

}
