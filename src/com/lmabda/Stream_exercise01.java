package com.lmabda;

import com.sun.org.apache.xpath.internal.operations.String;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream 的四种方式
 */
public class Stream_exercise01 {
    @Test
    public void test1() {
        //第一种
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        //第二种
        int[] ints = new int[10];
        IntStream stream1 = Arrays.stream(ints);

        //第三种
        String string = new String();
        Stream<String> string1 = Stream.of(string);

        //第四种
        Stream<Integer> iterate = Stream.iterate(0, x -> x + 2);
        iterate.limit(10).forEach(System.out::println);

        Stream<Double> generate = Stream.generate(() -> Math.random());
        generate.limit(10).forEach(System.out::println);
    }
}
