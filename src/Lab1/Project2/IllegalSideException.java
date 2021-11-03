package Lab1.Project2;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/11/03
 *     desc   :
 *     version:
 * </pre>
 */
public class IllegalSideException extends Exception {
    private final double side1;
    private final double side2;
    private final double side3;

    public IllegalSideException(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public String getMessage() {
        return "Illegal Sides: " + side1 + " " + side2 + " " + side3;
    }
}
