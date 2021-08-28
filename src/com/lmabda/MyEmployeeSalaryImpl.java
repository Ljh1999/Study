package com.lmabda;

public class MyEmployeeSalaryImpl implements MyEmployee<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() > 5000;
    }
}
