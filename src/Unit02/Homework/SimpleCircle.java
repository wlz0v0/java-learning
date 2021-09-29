package Unit02.Homework;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/29
 *     desc   :
 *     version:
 * </pre>
 */
public class SimpleCircle {
    private final double PI = 3.14;
    private static int numOfObjects = 0;
    private double radius;

    public SimpleCircle(double radius) {
        this.radius = radius;
        ++numOfObjects;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static int getNumOfObjects() {
        return numOfObjects;
    }

    @Override
    protected void finalize() {
        System.out.println("Circle: bye bye memory!");
        --numOfObjects;
    }
}
