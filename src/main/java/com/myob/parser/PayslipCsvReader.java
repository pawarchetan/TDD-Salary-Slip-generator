package com.myob.parser;

import com.myob.Employee;
import com.myob.PayslipInputInfo;

import java.math.BigDecimal;

import static com.myob.util.BigDecimalUtil.ensureWithinRange;
import static com.myob.util.BigDecimalUtil.parseAsDecimal;
import static com.myob.util.StringUtil.parseAsPercentage;

public class PayslipCsvReader {
    private static final String SEPARATOR = ",";

    public PayslipInputInfo parse(String csvLine){
        String[] csvValues = csvLine.split(SEPARATOR);
        String employeeFirstName = csvValues[0];
        String employeeLastName = csvValues[1];
        BigDecimal grossSalary = validateGrossSalary(csvValues[2]);

        Employee employee = new Employee(employeeFirstName, employeeLastName, grossSalary);
        BigDecimal superRate = validateSuperRate(csvValues[3]);
        String paymentStartDate = csvValues[4];

        return new PayslipInputInfo(employee, superRate, paymentStartDate);
    }

    private BigDecimal validateSuperRate(String csvValue){
        BigDecimal superRate = parseAsPercentage(csvValue);
        ensureWithinRange(superRate, BigDecimal.ZERO, BigDecimal.valueOf(100));
        return superRate;
    }

    private BigDecimal validateGrossSalary(String csvValue){
        BigDecimal grossSalary = parseAsDecimal(csvValue);
        ensureWithinRange(grossSalary, BigDecimal.ZERO, BigDecimal.valueOf(Integer.MAX_VALUE));
        return grossSalary;
    }
}
