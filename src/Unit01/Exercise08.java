package Unit01;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/15
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise08 {
    public static void main(String[] args) {
        dataType(3.5);
        dataType(3.50);
        dataType(0.0);
        dataType(0);
        dataType(0.);
        dataType(3d);
        dataType(3f);
        dataType(3);
        dataType('c');
    }

    static void dataType(int x) {
        System.out.printf("Integer: %d\n", x);
    }

    static void dataType(double x) {
        System.out.printf("Double: %f\n", x);
    }

    static void dataType(char x) {
        System.out.printf("Char: %c\n", x);
    }

    static void dataType(float x) {
        System.out.printf("Float: %f\n", x);
    }
}
