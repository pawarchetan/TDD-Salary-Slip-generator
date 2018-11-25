# Employee monthly pay slip

## Technology Stack :
  - Java8
  - Junit
  - Maven
  - IDE Used : Intellij
  - Test Driven Development (Development Approach)
  
## Object Calisthenics : (http://www.markhneedham.com/blog/2008/11/06/object-calisthenics-first-thoughts/)
  Below code / object calisthenics are followed while writing the code.
  - Use only one level of indentation per method : Followed
  - Don’t use the else keyword : Followed 
  - Wrap all primitives and strings : Mostly followed, but at some places it was not possible.
  - Use only one dot per line : Followed
  - Don’t abbreviate : Followed
  - Keep all entities small : Followed (Maximum 50 Lines)
  - Don’t use any classes with more than two instance variables : Partially followed
  - Use first-class collections : Followed
  - Don’t use any getters/setters/properties : Followed
  
## Assumptions :
  - We are not reading CSV using any library. Assuming we are getting parsed CSV line , we just need to gather/extract data
  from it. 
  For Example , input will be : Ryan,Chen,120000,20%,01 March – 31 March
  - Headers of CSV file will be fixed, so we will get data in sequencial order.

## How to Run : 
The code can be compiled with command:

    mvn package
    
The tests can be executed with command:

    mvn verify
    
## Code Coverage : 
  - Right now we have 97% of code coverage. It is measured using Intellij code coverage plugin.
  
## Architecture / Design :
  - AnnualAmount / MonthlyAmount : As a part of object calisthenic - Wrapping primitives , we have wrapped BigDecimal amounts 
  to AnnualAmount and MonthlyAmount.
  - IncomeTaxCalculator : This class is responsible for finding the correct income tax bracket for given annual income and applying rules on top of it.It also returns Monthly Payable income tax.
  - We have CsvReader and CsvWriter to parse csv input line and to map csv line to java object.
  - PayslipGenerator : This class is responsible for generating payslip object.
  - Payslip : Java object used to represent output.
  - PayslipInputInfo : Java object used to represent input.
  - Amounts represented with BigDecimal to have more control over rounding problems.

## How to use API
  - Please find Example.java for more details.






