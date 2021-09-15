package Unit01;

import java.util.HashSet;
import java.lang.Math;

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
        HashSet<Integer> set = new HashSet<>();
        while (set.size() != 10) {
            double r = Math.random();
            int i = (int) (r * Math.round(10.0));
            set.add(i);
        }
        for (var s : set) {
            System.out.println(s);
        }
    }
}
