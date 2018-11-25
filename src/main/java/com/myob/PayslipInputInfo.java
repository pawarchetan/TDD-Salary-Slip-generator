package com.myob;

import java.math.BigDecimal;

public class PayslipInputInfo {

    private Employee employee;
    private BigDecimal superRate;
    private String paymentStartDate;

    public PayslipInputInfo(Employee employee, BigDecimal superRate, String paymentStartDate) {
        this.employee = employee;
        this.superRate = superRate;
        this.paymentStartDate = paymentStartDate;
    }

    public Employee employee() {
        return this.employee;
    }

    public BigDecimal superRate(){
        return this.superRate;
    }

    public String paymentStartDate(){
        return this.paymentStartDate;
    }
}
