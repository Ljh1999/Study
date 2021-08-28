package com.lmabda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Stream_exercise02 {
    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
                new Employee("小王", 34, 3333.33),
                new Employee("小刘", 37, 9999.99),
                new Employee("小罗", 43, 8888.88),
                new Employee("老谢", 65, 7777.77),
                new Employee("帅多", 32, 5555.55)
        );
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");

        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream().map(Stream_exercise02::character);
        streamStream.forEach(x ->x.forEach(System.out::println));

        list.stream().flatMap(Stream_exercise02::character).forEach(System.out::println);

        Optional<Employee> first = emps.stream().sorted((x, y) -> -Double.compare(x.getSalary(), y.getSalary())).findFirst();
        Employee employee = first.get();

        System.out.println(employee);

    }
    public static Stream<Character> character(String str) {
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
             list.add(character);
        }
       return list.stream();
    }
}
