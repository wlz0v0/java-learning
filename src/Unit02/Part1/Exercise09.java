package Unit02.Part1;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/09/22
 *     desc   :
 *     version:
 * </pre>
 */
public class Exercise09 {
    public static void main(String[] args) {
        char[][] arr = {
                {'a', 'b', 'c', 'd'},
                {'x', 'y', 'z'},
                {'1', '2'}
        };
        for (var chs : arr) {
            System.out.println("length: " + chs.length);
            for (var ch : chs) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}

