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
    private final SendCallback sendCallback;
    private final ReceiveCallback receiveCallback;
    public Choice choice;
    public int millis;
    public volatile boolean stop = false;

    /**
     * @param sendCallback    发送数据回调函数
     * @param receiveCallback 接收数据回调函数
     */
    public RandomChoiceThread(SendCallback sendCallback, ReceiveCallback receiveCallback) {
        this.sendCallback = sendCallback;
        this.receiveCallback = receiveCallback;
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
            receiveCallback.receive();
        }
        stop = true;
    }

    public interface SendCallback {
        void send(Choice choice, int sleepDuration);
    }

    public interface ReceiveCallback {
        void receive();
    }
}
