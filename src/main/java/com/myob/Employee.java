package com.myob;

import java.math.BigDecimal;

public class Employee {

    private String firstName;
    private String lastName;
    private BigDecimal grossSalary;

    public Employee(String firstName, String lastName, BigDecimal grossSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grossSalary = grossSalary;
    }

    public static String fullNameOf(Employee employee) {
        return employee.firstName + " " + employee.lastName;
    }

    public BigDecimal grossSalary(){
        return grossSalary;
    }

    public String firstName(){
        return firstName;
    }

    public String lastName(){
        return lastName;
    }
}
