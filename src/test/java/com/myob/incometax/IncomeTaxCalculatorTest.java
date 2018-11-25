package com.myob.incometax;

import com.myob.IncomeTaxTableCreator;
import com.myob.amount.AnnualAmount;
import com.myob.amount.MonthlyAmount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class IncomeTaxCalculatorTest {

    private IncomeTaxCalculator incomeTaxCalculator;

    @Before
    public void setUp() {
        IncomeTaxTable incomeTaxTable = IncomeTaxTableCreator.generateTaxTable();
        incomeTaxCalculator = new IncomeTaxCalculator(incomeTaxTable);
    }

    @Test
    public void calculate_income_tax_from_annual_gross_salary(){
        AnnualAmount expectedIncomeTax = AnnualAmount.valueOf(BigDecimal.valueOf(922));
        AnnualAmount annualGrossSalary = new AnnualAmount(BigDecimal.valueOf(60050));

        MonthlyAmount actualIncomeTax = incomeTaxCalculator.calculateMonthlyPayableIncomeTaxFrom(annualGrossSalary);

        assertEquals(expectedIncomeTax.value() , actualIncomeTax.value());
    }

}
