package com.myob.incometax;

import com.myob.amount.AnnualAmount;

import java.util.List;
import java.util.Optional;

public class IncomeTaxTable {

    private List<IncomeTaxTableEntry> taxTableEntries;

    public IncomeTaxTable(List<IncomeTaxTableEntry> taxTableEntries) {
        this.taxTableEntries = taxTableEntries;
    }

    IncomeTaxBracket getTaxBracketFor(AnnualAmount yearlyTaxableIncome) {
        Optional<IncomeTaxTableEntry> incomeTaxTableEntryOptional = taxTableEntries.stream()
                .filter(
                        taxTableEntry -> taxTableEntry.meetsCriteriaForValidTaxTableEntryFor(yearlyTaxableIncome))
                .findFirst();
        IncomeTaxTableEntry tempTaxTableEntry = incomeTaxTableEntryOptional.orElse(null);

        validateIfTaxBracketFound(tempTaxTableEntry);
        return tempTaxTableEntry.incomeTaxBracket();
    }

    private void validateIfTaxBracketFound(IncomeTaxTableEntry taxTableEntry){
        if(taxTableEntry == null) {
            throw new IllegalArgumentException("Annual income invalid / no valid tax bracket found for income");
        }
    }
}
