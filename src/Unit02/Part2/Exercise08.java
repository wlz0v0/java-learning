package Unit02.Part2;

import java.util.Calendar;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise08 {
    public static void main(String[] args) {
        Calendar calendar2021 = Calendar.getInstance();
        calendar2021.set(2021, Calendar.OCTOBER, 1, 10, 0, 0);
        Calendar calendar1949 = Calendar.getInstance();
        calendar1949.set(1949, Calendar.OCTOBER, 1, 10, 0, 0);
        long end = calendar2021.getTimeInMillis();
        long start = calendar1949.getTimeInMillis();
        long days = (end - start) / 86400000;
        System.out.println(days);
    }
}
