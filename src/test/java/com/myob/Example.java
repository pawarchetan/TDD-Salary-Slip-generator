package com.myob;

import com.myob.incometax.IncomeTaxCalculator;
import com.myob.parser.PayslipCsvReader;
import com.myob.parser.PayslipCsvWriter;

import java.util.ArrayList;
import java.util.List;


//Use of API
public class Example {

    public static void main(String[] args){
        List<String> inputCsvLines = new ArrayList<>();
        inputCsvLines.add("Ryan,Chen,120000,20%,01 March – 31 March");
        inputCsvLines.add("David,Rudd,60050,9%,01 March – 31 March");

        inputCsvLines.forEach(inputCsvLine -> {
            PayslipCsvReader payslipCsvReader = new PayslipCsvReader();
            PayslipInputInfo payslipInputInfo = payslipCsvReader.parse(inputCsvLine);

            IncomeTaxCalculator incomeTaxCalculator = new IncomeTaxCalculator(IncomeTaxTableCreator.generateTaxTable());  //pass required income tax slab details

            PayslipGenerator payslipGenerator = new PayslipGenerator(incomeTaxCalculator);
            Payslip payslip = payslipGenerator.generatePayslipFor(payslipInputInfo);

            PayslipCsvWriter payslipCsvWriter = new PayslipCsvWriter();
            String csvLine = payslipCsvWriter.write(payslip);

            System.out.println("Result :- \n\t Input : " + inputCsvLine + "\n\t Output : " + csvLine);
        });
    }
}
