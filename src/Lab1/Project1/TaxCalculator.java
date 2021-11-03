package Lab1.Project1;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/11/03
 *     desc   :
 *     version:
 * </pre>
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
