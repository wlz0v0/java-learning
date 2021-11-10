package Lab1.Project1;

/**
 * CalculatorManager.java
 */
@SuppressWarnings("FieldCanBeLocal")
public class CalculatorManager {
    private final TaxCalculator taxCalculator1 = new TaxCalculator(0.03, 0, 36000);
    private final TaxCalculator taxCalculator2 = new TaxCalculator(0.1, 36000, 144000);
    private final TaxCalculator taxCalculator3 = new TaxCalculator(0.2, 144000, 300000);
    private final TaxCalculator taxCalculator4 = new TaxCalculator(0.25, 300000, 420000);
    private final TaxCalculator taxCalculator5 = new TaxCalculator(0.3, 420000, 660000);
    private final TaxCalculator taxCalculator6 = new TaxCalculator(0.35, 660000, 960000);
    private final TaxCalculator taxCalculator7 = new TaxCalculator(0.45, 960000, Double.MAX_VALUE);

    public CalculatorManager() {
        taxCalculator1.setNext(taxCalculator2);
        taxCalculator2.setNext(taxCalculator3);
        taxCalculator3.setNext(taxCalculator4);
        taxCalculator4.setNext(taxCalculator5);
        taxCalculator5.setNext(taxCalculator6);
        taxCalculator6.setNext(taxCalculator7);
    }

    public double calculate(double annualIncome) {
        return taxCalculator1.calculate(annualIncome);
    }
}
