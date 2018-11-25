package com.myob;

import com.myob.incometax.IncomeTaxCalculator;
import com.myob.incometax.IncomeTaxTable;
import org.junit.Test;

import java.math.BigDecimal;

import static com.myob.IncomeTaxTableCreator.generateTaxTable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PayslipGeneratorTest {

    @Test
    public void generate_payslip_for_give_csv_input(){
        Employee employee = new Employee("Ryan", "Chen", BigDecimal.valueOf(120000));
        PayslipInputInfo payslipInputInfo = new PayslipInputInfo(employee, new BigDecimal(10),
                "01 March - 31 March");
        PayslipGenerator payslipGenerator = getPayslipGeneratorObject();

        Payslip actualPayslip = payslipGenerator.generatePayslipFor(payslipInputInfo);

        assertNotNull(actualPayslip);
        assertEquals("Ryan Chen",actualPayslip.name());
        assertEquals("01 March - 31 March", actualPayslip.paymentStartDate());
        assertEquals(BigDecimal.valueOf(10000), actualPayslip.grossIncome());
        assertEquals(BigDecimal.valueOf(2669), actualPayslip.incomeTax());
        assertEquals(BigDecimal.valueOf(7331), actualPayslip.netIncome());
        assertEquals(BigDecimal.valueOf(1000), actualPayslip.superRate());

    }

    private PayslipGenerator getPayslipGeneratorObject() {
        IncomeTaxTable incomeTaxTable = generateTaxTable();
        IncomeTaxCalculator incomeTaxCalculator = new IncomeTaxCalculator(incomeTaxTable);
        return new PayslipGenerator(incomeTaxCalculator);
    }
}
