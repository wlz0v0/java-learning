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
public class Exercise08 {
    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j) {
                arr[i][j] = (i + 1) * (j + 1);
            }
        }
        for (var a :arr) {
            for (var b : a) {
                System.out.println(b);
            }
        }
    }
}

