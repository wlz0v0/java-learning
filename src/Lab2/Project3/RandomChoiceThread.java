package Lab2.Project3;

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
public class RandomChoiceThread extends Thread {
    public Choice choice;
    public int millis;
    // 使用volatile关键字保证字段在c线程的可见性
    public volatile boolean stop = true;
    private final SendCallback sendCallback;

    public RandomChoiceThread(SendCallback sendCallback) {
        this.sendCallback = sendCallback;
    }

    @Override
    public void run() {
        var random = new Random();
        for (int i = 1; i <= SocketServer.round; ++i) {
            // 睡眠小于1s时间
            try {
                millis = random.nextInt(1000);
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            choice = Choice.valueOf(random.nextInt(3));
            sendCallback.send(choice, millis);
            stop = false;
            while (!stop) {
                Thread.onSpinWait();
            }
        }
    }

    public interface SendCallback {
        void send(Choice choice, int sleepDuration);
    }
}
