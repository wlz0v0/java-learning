package Lab1.Project2;

/**
 * TriangleTest.java
 */
public class TriangleTest {
    public static void main(String[] args) {
        Triangle triangle1 = null;
        Triangle triangle2 = null;
        try {
            triangle1 = new Triangle(1, 1.5, 1);
            triangle2 = new Triangle(-1, 0, 1);
        } catch (IllegalSideException e) {
            e.printStackTrace();
        }
        if (triangle1 != null) {
            System.out.println(triangle1);
            System.out.println(triangle1.getArea());
            System.out.println(triangle1.getPerimeter());
        }
        if (triangle2 != null) {
            System.out.println(triangle2);
            System.out.println(triangle2.getArea());
            System.out.println(triangle2.getPerimeter());
        }
    }
}
