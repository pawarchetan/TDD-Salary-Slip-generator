package com.myob.util;

import com.myob.amount.AnnualAmount;
import com.myob.incometax.IncomeTaxBracket;

import java.math.BigDecimal;

public class TaxHelper {

    public static BigDecimal calculateMarginalTax(AnnualAmount yearlyTaxableIncome, IncomeTaxBracket incomeTaxBracket) {
        BigDecimal marginalTaxableAmount = calculateMarginalTaxableAmount(yearlyTaxableIncome, incomeTaxBracket);
        return marginalTaxableAmount.multiply(incomeTaxBracket.getMarginalTaxRate());
    }

    private static BigDecimal calculateMarginalTaxableAmount(AnnualAmount yearlyTaxableIncome, IncomeTaxBracket incomeTaxBracket) {
        return yearlyTaxableIncome.value().subtract(incomeTaxBracket.getIncomeThreshold());
    }
}
