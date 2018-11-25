package com.myob.incometax;

import com.myob.IncomeTaxTableCreator;
import com.myob.amount.AnnualAmount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IncomeTaxTableTest {

    private IncomeTaxTable incomeTaxTable;

    @Before
    public void setUp() {
        incomeTaxTable = IncomeTaxTableCreator.generateTaxTable();
    }

    @Test
    public void get_correct_tax_bracket_from_tax_table() {
        IncomeTaxBracket expectedIncomeTaxBracket = new IncomeTaxBracket(BigDecimal.valueOf(3572), BigDecimal.valueOf(0.325), BigDecimal.valueOf(37000));
        IncomeTaxBracket actualIncomeTaxBracket = incomeTaxTable.getTaxBracketFor(AnnualAmount.valueOf(BigDecimal.valueOf(60050)));

        assertNotNull(actualIncomeTaxBracket);
        assertEquals(expectedIncomeTaxBracket.getAccumulatedTaxFromPreviousBracket(),actualIncomeTaxBracket.getAccumulatedTaxFromPreviousBracket());
        assertEquals(expectedIncomeTaxBracket.getMarginalTaxRate(),actualIncomeTaxBracket.getMarginalTaxRate());
        assertEquals(expectedIncomeTaxBracket.getIncomeThreshold(),actualIncomeTaxBracket.getIncomeThreshold());

    }

    @Test(expected = IllegalArgumentException.class)
    public void throw_exception_when_annual_gross_income_is_invalid(){
        incomeTaxTable.getTaxBracketFor(AnnualAmount.valueOf(BigDecimal.valueOf(-500)));
    }
}
