package com.myob.amount;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class AnnualAmountTest {

    @Test
    public void calculate_monthly_income_from_annual_gross_salary(){
        AnnualAmount annualAmount = new AnnualAmount(BigDecimal.valueOf(480));

        MonthlyAmount actualMonthlyAmount = annualAmount.toMonthly();

        assertEquals(BigDecimal.valueOf(40), actualMonthlyAmount.value());
    }

}

