package com.lmabda;

public class MyEmployeeImpl implements MyEmployee<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() > 35;
    }
}
