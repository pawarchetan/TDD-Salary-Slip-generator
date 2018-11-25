package com.myob.amount;

import java.math.BigDecimal;

public class AnnualAmount {

    private final BigDecimal value;

    public AnnualAmount(final BigDecimal value) {
        this.value = value;
    }

    public MonthlyAmount toMonthly () {
        return MonthlyAmount.valueOf(value.divide(BigDecimal.valueOf(12), 0, BigDecimal.ROUND_HALF_DOWN));
    }

    public static AnnualAmount valueOf (final BigDecimal value) {
        return new AnnualAmount(value);
    }

    public BigDecimal value(){
        return value;
    }
}
