package com.myob;

import com.myob.amount.MonthlyAmount;

import java.math.BigDecimal;

public class Payslip {

    private String name;
    private String paymentStartDate;
    private MonthlyAmount grossIncome;
    private MonthlyAmount incomeTax;
    private MonthlyAmount netIncome;
    private MonthlyAmount superRate;

    public Payslip(String name, String paymentStartDate, MonthlyAmount grossIncome, MonthlyAmount incomeTax,
                   MonthlyAmount netIncome, MonthlyAmount superRate) {
        this.name = name;
        this.paymentStartDate = paymentStartDate;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superRate = superRate;
    }

    public String name(){
        return this.name;
    }

    public String paymentStartDate(){
        return this.paymentStartDate;
    }

    public BigDecimal grossIncome(){
        return this.grossIncome.value();
    }

    public BigDecimal incomeTax(){
        return this.incomeTax.value();
    }

    public BigDecimal netIncome(){
        return this.netIncome.value();
    }

    public BigDecimal superRate(){
        return this.superRate.value();
    }
}
