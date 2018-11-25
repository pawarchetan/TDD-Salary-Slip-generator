package com.myob.incometax;

import com.myob.amount.AnnualAmount;

import java.math.BigDecimal;

public class IncomeTaxTableEntry {

    private BigDecimal minThreshold;
    private BigDecimal maxThreshold;
    private IncomeTaxBracket incomeTaxBracket;

    private IncomeTaxTableEntry(BigDecimal minThreshold, BigDecimal maxThreshold, IncomeTaxBracket incomeTaxBracket) {
        this.minThreshold = minThreshold;
        this.maxThreshold = maxThreshold;
        this.incomeTaxBracket = incomeTaxBracket;
    }

    public static IncomeTaxTableEntry createWith(BigDecimal minThreshold,
                                                 BigDecimal maxThreshold,
                                                 BigDecimal accumulatedTaxFromPreviousBracket,
                                                 BigDecimal marginalTaxRate){
        BigDecimal incomeThreshold = calculateIncomeThreshold(minThreshold);
        IncomeTaxBracket taxBracket = new IncomeTaxBracket(accumulatedTaxFromPreviousBracket, marginalTaxRate, incomeThreshold);
        return new IncomeTaxTableEntry(minThreshold, maxThreshold, taxBracket);
    }

    public boolean meetsCriteriaForValidTaxTableEntryFor(AnnualAmount yearlyTaxableIncome) {
        return !(yearlyTaxableIncome.value().compareTo(this.minThreshold) < 0) && !(yearlyTaxableIncome.value().compareTo(this.maxThreshold) > 0);
    }

    public IncomeTaxBracket incomeTaxBracket() {
        return this.incomeTaxBracket;
    }

    private static BigDecimal calculateIncomeThreshold(BigDecimal minThreshold) {
        return minThreshold.subtract(BigDecimal.ONE).compareTo(BigDecimal.ZERO) > 0 ? minThreshold.subtract(BigDecimal.ONE) : BigDecimal.ZERO;
    }
}
