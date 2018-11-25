package com.myob.incometax;

import java.math.BigDecimal;

public class IncomeTaxBracket {

    private BigDecimal accumulatedTaxFromPreviousBracket;
    private BigDecimal marginalTaxRate;
    private BigDecimal incomeThreshold;

    public IncomeTaxBracket(BigDecimal accumulatedTaxFromPreviousBracket, BigDecimal marginalTaxRate, BigDecimal incomeThreshold) {
        this.accumulatedTaxFromPreviousBracket = accumulatedTaxFromPreviousBracket;
        this.marginalTaxRate = marginalTaxRate;
        this.incomeThreshold = incomeThreshold;
    }

    public BigDecimal getAccumulatedTaxFromPreviousBracket() {
        return accumulatedTaxFromPreviousBracket;
    }

    public BigDecimal getMarginalTaxRate() {
        return marginalTaxRate;
    }

    public BigDecimal getIncomeThreshold() {
        return incomeThreshold;
    }
}
