package FinalTerm.Question3;

import java.util.Random;

public class PubSubTest {
    /**
     * 消息总数
     */
    private final static int msgCnt = 20;

    public static void main(String[] args) {
        // 实例化所需对象
        var buffer = new Buffer(5);
        var pub = new Publisher(buffer);
        var sub = new Subscriber(buffer);
        var random = new Random();

        // 创建一个线程，发送msgCnt条消息
        new Thread(() -> {
            for (int i = 0; i < msgCnt; ++i) {
                pub.publish();
                try {
                    // 发布后睡眠不超过0.5s的随机时间
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        // 创建一个线程，接收msgCnt条消息
        new Thread(() -> {
            for (int i = 0; i < msgCnt; ++i) {
                sub.subscribe();
                try {
                    // 接收后睡眠不超过0.5s的随机时间
                    Thread.sleep(random.nextInt(500));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
