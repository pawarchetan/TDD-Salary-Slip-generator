package com.myob.parser;

import com.myob.Payslip;
import com.myob.amount.MonthlyAmount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PayslipCsvWriterTest {

    private PayslipCsvWriter payslipCsvWriter;

    @Before
    public void init(){
        payslipCsvWriter = new PayslipCsvWriter();
    }

    @Test
    public void write_csv_format_string_from_java_object(){
        String csvLine = payslipCsvWriter.write(payslip());

        assertEquals("Ryan Chen,01 March - 31 March,10000,2669,7331,1000", csvLine);
    }

    private Payslip payslip(){
        return new Payslip("Ryan Chen",
                "01 March - 31 March",
                MonthlyAmount.valueOf(BigDecimal.valueOf(10000)),
                MonthlyAmount.valueOf(BigDecimal.valueOf(2669)),
                MonthlyAmount.valueOf(BigDecimal.valueOf(7331)),
                MonthlyAmount.valueOf(BigDecimal.valueOf(1000)));
    }
}
