package com.lmabda;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public class Stream_Homework {
    @Test
    public void test1() {
        int[] ints = {1, 2, 3, 4, 5};
        Arrays.stream(ints).map((x) -> x * x).forEach(System.out::println);
    }

    List<Employee> list = Arrays.asList(
            new Employee("小王", 34, 3333.33),
            new Employee("小刘", 37, 9999.99),
            new Employee("小罗", 43, 8888.88),
            new Employee("老谢", 65, 7777.77),
            new Employee("帅多", 32, 5555.55)
    );

    @Test
    public void test2() {
        Optional<Integer> reduce = list.stream().map(employee -> 1).reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    @Test
    public void test3() {
        Instant now = Instant.now();
        LongStream.rangeClosed(0, 1000000000L)
                .parallel()
                .reduce(0,Long::sum);
        Instant now1 = Instant.now();
        System.out.println("话费时间为：" + Duration.between(now, now1).toMillis());
    }
}
