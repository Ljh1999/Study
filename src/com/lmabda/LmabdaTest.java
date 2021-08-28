package com.lmabda;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 为什么使用lmabda
 */
public class LmabdaTest {
    @Test
    public void test1() {
        //原来的匿名内部类
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                return Integer.compare(x, y);
            }
        };
        TreeSet<Integer> integers = new TreeSet<>(comparator);
    }
    //Lmabda 表达式
    @Test
    public void test2() {

        Comparator<Integer> comparator1 = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> integers1 = new TreeSet<>(comparator1);
    }

    List<Employee> employees = Arrays.asList(
            new Employee("小王", 34, 3333.33),
            new Employee("小刘", 37, 9999.99),
            new Employee("小罗", 43, 8888.88),
            new Employee("小老谢", 65, 7777.77),
            new Employee("帅多", 32, 5555.55)
    );

    @Test
    public void test3() {
        List<Employee> byAgeEmplyess = findByAgeEmplyess(employees);
        for (Employee ageEmplyess : byAgeEmplyess) {
            System.out.println(ageEmplyess);
        }
    }
    @Test
    public void test4() {
        List<Employee> bySalaryEmplyess = findBySalaryEmplyess(employees);
        for (Employee SalaryEmplyess : bySalaryEmplyess) {
            System.out.println(SalaryEmplyess);
        }
    }


    //需求：获取当前公司中年龄大于35岁的员工信息
    public List<Employee> findByAgeEmplyess(List<Employee> list) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() > 35) {
                employees.add(employee);
            }
        }
        return employees;
    }

    //需求：获取当前公司中工资大于5000的员工信息
    public List<Employee> findBySalaryEmplyess(List<Employee> list) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() > 5000) {
                employees.add(employee);
            }
        }
        return employees;
    }
    //优化方式一：策略设计模式
    @Test
    //按年龄
    public void test5(){
        List<Employee> list = findEmployee(employees, new MyEmployeeImpl());
        for (Employee employee : list) {
            System.out.println(employee);
        }
        System.out.println("------------------");
        //按薪水
        List<Employee> list1 = findEmployee(employees, new MyEmployeeSalaryImpl());
        for (Employee employee : list1) {
            System.out.println(employee);
        }
    }


    public List<Employee> findEmployee(List<Employee> list,MyEmployee<Employee> myEmployee){
        ArrayList<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if(myEmployee.test(employee)){
                employees.add(employee);
            }
        }
        return employees;
    }

    //优化方式二：匿名内部类
    @Test
    public void test6(){
        List<Employee> list = findEmployee(employees, new MyEmployee<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getAge() > 35;
            }
        });

        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式三：Lmabda表达式
    @Test
    public void test7(){
        List<Employee> employee = findEmployee(employees, (e) -> e.getSalary() > 6000);
        employee.forEach(System.out::println);
    }

    //优化方式四：Stream API
    @Test
    public void test8(){
        employees.stream().filter((e) -> e.getSalary() > 5000).forEach(System.out::println);

        System.out.println("------------------------------");
        //获取所有name
        employees.stream().map(Employee::getName).forEach(System.out::println);

    }

}
