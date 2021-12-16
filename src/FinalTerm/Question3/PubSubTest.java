package FinalTerm.Question3;

import java.util.Random;

/**
 * <pre>
 *     author : 武连增
 *     e-mail : wulianzeng@bupt.edu.cn
 *     time   : 2021/12/16
 *     desc   :
 *     version:
 * </pre>
 */
public class PubSubTest {
    public static void main(String[] args) {
        var buffer = new Buffer(5);
        var pub = new Publisher(buffer);
        var sub = new Subscriber(buffer);
        var random = new Random();
        new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                pub.publish();
                try {
                    Thread.sleep(random.nextInt(50));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; ++i) {
                sub.subscribe();
                try {
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
