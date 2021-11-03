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
public class Tax {
    private final double annualIncome;
    private final double monthlyIncome;
    private final double monthlyTax;
    private final double annualTax;
    private final static CalculatorManager manager = new CalculatorManager();

    public Tax(double annualIncome) {
        this.annualIncome = annualIncome;
        annualTax = manager.calculate(annualIncome - 60000);
        monthlyIncome = annualIncome / 12;
        monthlyTax = annualTax / 12;
    }

    @Override
    public String toString() {
        return (int) annualIncome + "\t"
                + (int) annualTax + "\t"
                + (int) monthlyIncome + "\t"
                + (int) monthlyTax;
    }
}
