package com.myob.amount;

import java.math.BigDecimal;

public class MonthlyAmount {

    private final BigDecimal value;

    public MonthlyAmount(final BigDecimal value) {
        this.value = value.setScale(0, BigDecimal.ROUND_HALF_DOWN);
    }

    public static MonthlyAmount valueOf (final BigDecimal value) {
        return new MonthlyAmount(value);
    }

    public BigDecimal value () {
        return value;
    }
    
}
