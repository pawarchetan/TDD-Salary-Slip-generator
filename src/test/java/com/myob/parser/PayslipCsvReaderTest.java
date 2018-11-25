package com.myob.parser;

import com.myob.PayslipInputInfo;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PayslipCsvReaderTest {

    private PayslipCsvReader payslipCsvReader;

    @Before
    public void init(){
        payslipCsvReader = new PayslipCsvReader();
    }

    @Test
    public void parse_csv_input_line(){
        PayslipInputInfo actualPayslipInputInfo = payslipCsvReader.parse("David,Rudd,60050,9%,01 March – 31 March");

        assertEquals("David", actualPayslipInputInfo.employee().firstName());
        assertEquals("Rudd", actualPayslipInputInfo.employee().lastName());
        assertEquals("01 March – 31 March", actualPayslipInputInfo.paymentStartDate());
        assertEquals(BigDecimal.valueOf(9), actualPayslipInputInfo.superRate());
        assertEquals(BigDecimal.valueOf(60050), actualPayslipInputInfo.employee().grossSalary());
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_super_is_out_of_range(){
        payslipCsvReader.parse("David,Rudd,60050,900%,01 March – 31 March");
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_gross_income_is_out_of_range(){
        payslipCsvReader.parse("David,Rudd,-60050,9%,01 March – 31 March");
    }
}
