package Unit05;

import java.util.Scanner;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/10/27
 *     desc   :
 *     version:
 * </pre>
 */
public class Quiz07 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int a, b;
        a = scanner.nextInt();
        b = scanner.nextInt();

        assert b != 0 : "divisor must not be zero!";
        try {
            System.out.println(divide(a, b));
        } catch (DividingZero e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("Done");
        }
    }

    private static double divide(int a, int b) throws DividingZero {
        if (b == 0) {
            throw new DividingZero();
        }
        return (double) a / b;
    }
}
