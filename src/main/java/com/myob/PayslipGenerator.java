package com.myob;

import com.myob.amount.AnnualAmount;
import com.myob.amount.MonthlyAmount;
import com.myob.incometax.IncomeTaxCalculator;

import java.math.BigDecimal;

public class PayslipGenerator {

    private IncomeTaxCalculator incomeTaxCalculator;

    public PayslipGenerator(IncomeTaxCalculator incomeTaxCalculator) {
        this.incomeTaxCalculator = incomeTaxCalculator;
    }

    public Payslip generatePayslipFor(PayslipInputInfo payslipInputInfo){
        Employee employee = payslipInputInfo.employee();
        BigDecimal superRate = payslipInputInfo.superRate();
        String paymentStartDate = payslipInputInfo.paymentStartDate();

        AnnualAmount annualAmount = AnnualAmount.valueOf(employee.grossSalary());
        MonthlyAmount monthlyAmount = calculateMonthlyIncome(annualAmount);
        MonthlyAmount monthlyIncomeTax = calculateMonthlyIncomeTax(annualAmount);
        MonthlyAmount netMonthlyIncome = calculateMonthlyNetIncome(monthlyAmount, monthlyIncomeTax);
        MonthlyAmount superMonthlyAmount = calculateSuperMonthlyAmount(monthlyAmount, superRate);

        return new Payslip(Employee.fullNameOf(employee),
                paymentStartDate,
                monthlyAmount,
                monthlyIncomeTax,
                netMonthlyIncome,
                superMonthlyAmount);
    }

    private MonthlyAmount calculateMonthlyIncome(AnnualAmount annualGrossSalary){
        return annualGrossSalary.toMonthly();
    }

    private MonthlyAmount calculateMonthlyIncomeTax(AnnualAmount annualGrossSalary){
        return incomeTaxCalculator.calculateMonthlyPayableIncomeTaxFrom(annualGrossSalary);
    }

    private MonthlyAmount calculateMonthlyNetIncome(MonthlyAmount monthlyAmount, MonthlyAmount monthlyIncomeTax){
        return MonthlyAmount.valueOf(monthlyAmount.value().subtract(monthlyIncomeTax.value()));
    }

    private MonthlyAmount calculateSuperMonthlyAmount(MonthlyAmount monthlyAmount, BigDecimal superRate){
        return MonthlyAmount.valueOf(monthlyAmount.value().multiply(superRate).divide(BigDecimal.valueOf(100)));
    }

}
