package com.myob;

import com.myob.amount.AnnualAmountTest;
import com.myob.incometax.IncomeTaxCalculatorTest;
import com.myob.incometax.IncomeTaxTableTest;
import com.myob.parser.PayslipCsvReaderTest;
import com.myob.parser.PayslipCsvWriterTest;
import com.myob.util.StringUtilTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({IncomeTaxTableTest.class, IncomeTaxCalculatorTest.class, AnnualAmountTest.class,
    PayslipGeneratorTest.class, StringUtilTest.class, PayslipCsvReaderTest.class, PayslipCsvWriterTest.class
})
public class PayslipTestSuite {
}
