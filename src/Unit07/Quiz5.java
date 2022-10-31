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

    public static void main(String[] args) throws InterruptedException {
        var addThread = new Thread(Quiz5::add);
        var subThread = new Thread(Quiz5::subtract);

        addThread.start();
        subThread.start();

        subThread.join();
        subThread.join();
    }

    public static synchronized void addX() {
        ++x;
    }

    public static synchronized void subtractAndPrintX() {
        --x;
        System.out.print(x + " ");
    }

    public static void add() {
        for (int i = 0; i < 20; ++i) {
            addX();
        }
    }

    public static void subtract() {
        for (int i = 0; i < 20; ++i) {
            subtractAndPrintX();
        }
    }
}
