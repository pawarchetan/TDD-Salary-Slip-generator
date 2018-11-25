package com.myob.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    public static BigDecimal parseAsDecimal(String stringDecimal){
        return new BigDecimal(stringDecimal);
    }

    public static void ensureWithinRange(BigDecimal value, BigDecimal min, BigDecimal max){
        if (value.compareTo(min) < 0) throw new IllegalArgumentException();
        if (value.compareTo(max) > 0) throw new IllegalArgumentException();
    }
}
