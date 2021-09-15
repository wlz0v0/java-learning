package Unit01;

import java.util.Random;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/15
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise09 {
    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(100));
        }
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(10));
        }
    }
}
