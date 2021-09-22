package Unit02Part1;

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
        char[] line1 = {'a', 'b', 'c', 'd'};
        char[] line2 = {'x', 'y', 'z'};
        char[] line3 = {'1', '2'};
        char[][] arr = {line1, line2, line3};
        for (var chs : arr) {
            System.out.println("length: " + chs.length);
            for (var ch : chs) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}

