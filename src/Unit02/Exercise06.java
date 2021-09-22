package Unit02;

import java.util.Scanner;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise06 {
    int one;
    static int two;
    public static void main(String[] args) {
        Exercise06 exercise06 = new Exercise06();
        Scanner scanner = new Scanner(System.in);
        exercise06.one = scanner.nextInt();
        Exercise06.two = scanner.nextInt();
        System.out.println(exercise06.one);
        System.out.println(Exercise06.two);
    }
}
