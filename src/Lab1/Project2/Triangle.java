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
public final class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() throws IllegalSideException {
        this(1.0, 1.0, 1.0);
    }

    public Triangle(double side1, double side2, double side3) throws IllegalSideException {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new IllegalSideException(side1, side2, side3);
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle:" +
                " side1 = " + side1 +
                " side2 = " + side2 +
                " side3 = " + side3;
    }
}
