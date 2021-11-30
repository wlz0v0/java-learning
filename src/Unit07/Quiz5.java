package Unit07;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/11/17
 *     desc   :
 *     version:
 * </pre>
 */
public class Quiz5 {
    static int x = 0;

    public static void main(String[] args) {
        new Thread(Quiz5::add).start();
        new Thread(Quiz5::subtract).start();
    }

    public static synchronized void add() {
        for (int i = 0; i < 20; ++i) {
            ++x;
            System.out.print(x + " ");
        }
    }

    public static synchronized void subtract() {
        for (int i = 0; i < 20; ++i) {
            --x;
            System.out.print(x + " ");
        }
    }
}
