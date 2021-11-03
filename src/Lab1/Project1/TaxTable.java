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
public class TaxTable {
    public static void main(String[] args) {
        for (int i = 60000; i <= 1000000; i += 10000) {
            Tax tax = new Tax(i);
            System.out.println(tax);
        }
    }
}
