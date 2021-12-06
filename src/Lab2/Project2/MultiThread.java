package Lab2.Project2;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/02
 *     desc   :
 *     version:
 * </pre>
 */
public class MultiThread {
    public final static int ROUND = 20;

    public static void main(String[] args) {
        var a = new RandomCharThread();
        var b = new RandomCharThread();
        var c = new Thread(new CompareRunnable(a, b));
        a.start();
        b.start();
        c.start();
    }
}
