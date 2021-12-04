package Lab2.Project2;

import java.util.Random;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/03
 *     desc   :
 *     version:
 * </pre>
 */
public class RandomCharThread extends Thread {
    public char ch;
    public int millis;
    // 使用volatile关键字保证字段在c线程的可见性
    public volatile boolean stop = true;

    @Override
    public void run() {
        var random = new Random();
        for (int i = 1; i <= Test.round; ++i) {
            // 睡眠小于1s时间
            try {
                millis = random.nextInt(1000);
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ch = (char) (random.nextInt(26) + 'a');
            stop = false;
            while (!stop) {
                Thread.onSpinWait();
            }
        }
    }
}
