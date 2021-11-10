package Lab1.Project1;

/**
 * TaxCalculator.java
 */
public class TaxCalculator {
    private final double rate;
    private final double low;
    private final double high;
    private TaxCalculator next;

    public TaxCalculator(double rate, double low, double high) {
        this.rate = rate;
        this.low = low;
        this.high = high;
        this.next = null;
    }

    public double calculate(double annualIncome) {
        if (annualIncome <= high) {
            return (annualIncome - low) * rate;
        }
        return (high - low) * rate + next.calculate(annualIncome);
    }

    public void setNext(TaxCalculator next) {
        this.next = next;
    }
}
