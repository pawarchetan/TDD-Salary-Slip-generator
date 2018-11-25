package com.myob.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private static final String strPattern = "^(\\d*.+\\d*)%$";

    public static BigDecimal parseAsPercentage(String input){
        Pattern pattern = Pattern.compile(strPattern);
        Matcher matcher = pattern.matcher(input);
        if(matcher.find()){
            String result = matcher.group(1);
            return BigDecimalUtil.parseAsDecimal(result);
        }
        throw new IllegalArgumentException("Super Rate is invalid");
    }
}
