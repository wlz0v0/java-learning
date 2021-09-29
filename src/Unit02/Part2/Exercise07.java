package Unit02.Part2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise07 {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = simpleDateFormat.parse("1949-10-01 10:00:00");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
