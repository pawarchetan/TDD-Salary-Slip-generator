package com.myob.parser;

import com.myob.Payslip;

import java.util.ArrayList;
import java.util.List;

public class PayslipCsvWriter {

    public String write(Payslip payslip){
        List<String> payslipContent = new ArrayList<>();
        payslipContent.add(payslip.name());
        payslipContent.add(payslip.paymentStartDate());
        payslipContent.add(String.valueOf(payslip.grossIncome()));
        payslipContent.add(String.valueOf(payslip.incomeTax()));
        payslipContent.add(String.valueOf(payslip.netIncome()));
        payslipContent.add(String.valueOf(payslip.superRate()));

        return String.join(",", payslipContent);
    }
}
