package com.myob.incometax;

import com.myob.amount.AnnualAmount;
import com.myob.amount.MonthlyAmount;

import java.math.BigDecimal;

import static com.myob.util.TaxHelper.calculateMarginalTax;

public class IncomeTaxCalculator {

    private final BigDecimal monthsInAYear = BigDecimal.valueOf(12);
    private IncomeTaxTable incomeTaxTable;

    public IncomeTaxCalculator(IncomeTaxTable incomeTaxTable) {
        this.incomeTaxTable = incomeTaxTable;
    }

    public MonthlyAmount calculateMonthlyPayableIncomeTaxFrom(AnnualAmount yearlyTaxableIncome){
        ensureValidValues(yearlyTaxableIncome);

        IncomeTaxBracket taxBracket = incomeTaxTable.getTaxBracketFor(yearlyTaxableIncome);
        AnnualAmount marginalTax = AnnualAmount.valueOf(calculateMarginalTax(yearlyTaxableIncome, taxBracket));

        return calculateMonthlyIncomeTax(taxBracket, marginalTax);
    }

    private void ensureValidValues(AnnualAmount yearlyTaxableIncome) {
        if (yearlyTaxableIncome.value().compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Annual Salary cannot be less than zero");
    }

    private MonthlyAmount calculateMonthlyIncomeTax(IncomeTaxBracket taxBracket, AnnualAmount marginalTax){
        BigDecimal monthlyIncomeTax = (taxBracket.getAccumulatedTaxFromPreviousBracket().add(marginalTax.value())).divide(monthsInAYear, BigDecimal.ROUND_DOWN);
        return MonthlyAmount.valueOf(monthlyIncomeTax);
    }

}
