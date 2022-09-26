package Unit06;

import java.io.File;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/10/27
 *     desc   :
 *     version:
 * </pre>
 */
public class Quiz01 {
    public static void main(String[] args) {
        var file = new File("./test.txt");
        if (file.exists()) {
            System.out.println(file.getAbsolutePath());
            System.out.println(file.length());
        }
    }
}
