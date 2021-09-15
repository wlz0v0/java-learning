package Unit01;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/15
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise06 {
    public static void main(String[] args) {
        var sum = 0;
        var i = 1;
        while (i <= 10) {
            sum += i;
            ++i;
        }
        System.out.printf("while statement result: %d\n", sum);
        sum = 0;
        i = 1;
        do {
            sum += i;
            ++i;
        } while (i <= 10);
        System.out.printf("do...while statement result: %d\n", sum);
        sum = 0;
        int[] arr = new int[10];
        for (int j = 1; j <= 10; ++j) {
            sum += j;
            arr[j - 1] = j;
        }
        System.out.printf("for statement result: %d\n", sum);
        sum = 0;
        for (var a : arr) {
            sum += a;
        }
        System.out.printf("for-each statement result: %d\n", sum);
    }
}
