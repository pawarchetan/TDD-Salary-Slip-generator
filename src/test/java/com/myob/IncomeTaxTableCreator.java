package com.myob;

import com.myob.incometax.IncomeTaxTable;
import com.myob.incometax.IncomeTaxTableEntry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IncomeTaxTableCreator {

    private static List<IncomeTaxTableEntry> taxTableEntries = new ArrayList<>();

    public static IncomeTaxTable generateTaxTable() {
        taxTableEntries.add(IncomeTaxTableEntry.createWith(BigDecimal.ZERO, BigDecimal.valueOf(18200), BigDecimal.ZERO, BigDecimal.ZERO));
        taxTableEntries.add(IncomeTaxTableEntry.createWith(BigDecimal.valueOf(18201), BigDecimal.valueOf(37000), BigDecimal.ZERO, BigDecimal.valueOf(0.19)));
        taxTableEntries.add(IncomeTaxTableEntry.createWith(BigDecimal.valueOf(37001), BigDecimal.valueOf(87000), BigDecimal.valueOf(3572), BigDecimal.valueOf(0.325)));
        taxTableEntries.add(IncomeTaxTableEntry.createWith(BigDecimal.valueOf(87001), BigDecimal.valueOf(180000), BigDecimal.valueOf(19822), BigDecimal.valueOf(0.37)));
        taxTableEntries.add(IncomeTaxTableEntry.createWith(BigDecimal.valueOf(180001), BigDecimal.valueOf(Double.MAX_VALUE),BigDecimal.valueOf(54232), BigDecimal.valueOf(0.45)));
        return new IncomeTaxTable(taxTableEntries);
    }
}
