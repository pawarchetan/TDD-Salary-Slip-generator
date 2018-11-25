package com.myob.util;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    @Test
    public void parse_super_percentage_string_and_get_decimal_in_super(){
        BigDecimal expectedPercentage = BigDecimal.valueOf(9);
        BigDecimal actualPercentage = StringUtil.parseAsPercentage("9%");

        assertEquals(expectedPercentage, actualPercentage);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_super_is_invalid(){
        StringUtil.parseAsPercentage("test");
    }
}
